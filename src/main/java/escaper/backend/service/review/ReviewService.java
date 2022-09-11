package escaper.backend.service.review;

import escaper.backend.dto.review.CreateRating;
import escaper.backend.dto.review.RatingResponse;
import escaper.backend.dto.review.ReviewResponse;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.review.CreateReview;
import escaper.backend.entity.review.Review;
import escaper.backend.entity.review.ReviewDto;
import escaper.backend.entity.theme.Theme;
import escaper.backend.error.exception.MemberException;
import escaper.backend.error.exception.ThemeException;
import escaper.backend.repository.review.ReviewRepository;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

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

        Optional<Review> result = reviewRepository.findReviewByUser(memberId, themeId);

        if (result.isPresent()) {
            Review findReview = result.get();
            findReview.updateReview(reviewDto.getContent());
            return reviewRepository.save(findReview).getId();
        }else{
            Review review = reviewDto.toEntity();
            review.addMember(findMember);
            review.addTheme(findTheme);
            return reviewRepository.save(review).getId();
        }
    }

    @Transactional
    public Long rateTheme(Long themeId, Long memberId, CreateRating createRating) {
        Theme findTheme = themeRepository.findById(themeId)
                .orElseThrow(() -> ThemeException.notFoundTheme(themeId));
        Member findMember = memberRepository.findById(memberId)
                .orElseThrow(() -> MemberException.notFoundMember(memberId));

        Double rating = createRating.getRating();
        validateRating(rating);
        Optional<Review> result = reviewRepository.findReviewByUser(memberId, themeId);

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

    public ReviewResponse<List<ReviewDto>> getReviews( Long themeId) {
        List<Review> ratingResult = reviewRepository.getRatingOfTheme(themeId);
        List<Review> result = reviewRepository.findReviewByThemeId(themeId);

        List<ReviewDto> collect = result.stream()
                .map(ReviewDto::new)
                .collect(toList());

        if (!ratingResult.isEmpty()) {
            int size = ratingResult.size();
            double sum = 0;
            for(Review review: ratingResult){
                sum+= review.getRating();
            }
            double average = sum /(double)size;
            return new ReviewResponse<>(ratingResult.size(), average, collect);
        }
        return new ReviewResponse<>(0, 0, collect);
    }


    private void validateRating(Double rating) {
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
