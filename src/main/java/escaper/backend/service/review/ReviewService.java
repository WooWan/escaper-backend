package escaper.backend.service.review;

import escaper.backend.dto.review.CreateRating;
import escaper.backend.dto.review.RatingResponse;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.review.CreateReview;
import escaper.backend.entity.review.Review;
import escaper.backend.entity.theme.Theme;
import escaper.backend.error.exception.MemberException;
import escaper.backend.error.exception.ThemeException;
import escaper.backend.repository.review.ReviewRepository;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ThemeRepository themeRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveReview(CreateReview reviewDto,Long memberId, Long themeId) {
        Theme findTheme = themeRepository.findById(themeId)
                .orElseThrow(() -> ThemeException.notFoundTheme(themeId));
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> MemberException.notFoundMember(memberId));

        Review review = reviewDto.toEntity();
        updateReview(findTheme, findMember, review);

        reviewRepository.save(review);
        return review.getId();
    }

    @Transactional
    public Long rateTheme(Long themeId, Long memberId, CreateRating createRating) {
        Double rating = createRating.getRating();
        validateRating(rating);

        Optional<Review> result = reviewRepository.findReviewByUser(memberId, themeId);
        Theme findTheme = themeRepository.findById(themeId)
                .orElseThrow(() -> ThemeException.notFoundTheme(themeId));
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> MemberException.notFoundMember(memberId));

        //카페 평점도 업데이트 해야한다.
        Cafe findCafe = findTheme.getCafe();

        findTheme.updateRating(rating);
        //유저가 해당 테마에 리뷰가 있을 경우,
        if (result.isPresent()) {
            Review findReview = result.get();
            findReview.rateTheme(rating);
            return reviewRepository.save(findReview).getId();
        }else{
            Review review = new Review();
            review.rateTheme(rating);
            updateReview(findTheme, findMember, review);
            return reviewRepository.save(review).getId();
        }
    }

    public void validateRating(Double rating) {
        Double reviewUnit = 0.5;
        if (rating % reviewUnit != 0) {
            throw new IllegalArgumentException("평점은 0.5 단위 입니다.");
        }
    }

    public void updateReview(Theme theme, Member member, Review review) {
        review.addTheme(theme);
        review.addMember(member);
    }

    public RatingResponse fetchThemeRatingOfUser(Long themeId, Long memberId) {
        Optional<Review> result = reviewRepository.findReviewByUser(memberId, themeId);
        Double userRating;
        if (result.isEmpty()) {
            userRating = 0.0;
        }else{
            userRating = result.get().getRating();
        }
        return ReviewConverter.toRatingResponse(userRating);
    }
}
