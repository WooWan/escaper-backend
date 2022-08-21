package escaper.backend.service;

import escaper.backend.dto.review.CreateRating;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.review.CreateReview;
import escaper.backend.entity.review.Review;
import escaper.backend.entity.theme.Theme;
import escaper.backend.error.exception.MemberException;
import escaper.backend.error.exception.ReviewException;
import escaper.backend.repository.review.ReviewRepository;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 방탈출 테마입니다."));
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> MemberException.notFoundMember(memberId));
        Review review = reviewDto.toEntity();
        review.addTheme(findTheme);
        review.addMember(findMember);

        reviewRepository.save(review);
        return review.getId();
    }

    @Transactional
    public Long rateTheme(Long themeId, Long memberId, CreateRating createRating) {
        Double rating = createRating.getRating();
        validateRating(rating);
        Review findReview = reviewRepository.findReviewByUser(memberId, themeId)
                .orElseThrow(() -> ReviewException.notFoundReview(memberId, themeId));

        findReview.rateTheme(rating);

        return reviewRepository.save(findReview).getId();
    }

    public void validateRating(Double rating) {
        Double reviewUnit = 0.5;
        if (rating % reviewUnit != 0) {
            throw new IllegalArgumentException("평점은 0.5 단위 입니다.");
        }
    }

}
