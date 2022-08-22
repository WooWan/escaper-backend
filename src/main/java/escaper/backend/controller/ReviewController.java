package escaper.backend.controller;

import escaper.backend.dto.review.CreateRating;
import escaper.backend.dto.review.RatingResponse;
import escaper.backend.entity.review.CreateReview;
import escaper.backend.entity.review.Review;
import escaper.backend.entity.review.ReviewDto;
import escaper.backend.repository.review.ReviewRepository;
import escaper.backend.service.review.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.*;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;
    private final ReviewRepository reviewRepository;

    @PostMapping("/api/review/{themeId}/member/{memberId}")
    public Long registerReview(@PathVariable Long themeId, @PathVariable Long memberId, @RequestBody @Valid CreateReview reviewDto) {
        return reviewService.saveReview(reviewDto, memberId, themeId);
    }
    @PostMapping("/api/rate/{themeId}/member/{memberId}")
    public Long rateTheme(@PathVariable Long themeId, @PathVariable Long memberId, @RequestBody CreateRating rating) {
        return reviewService.rateTheme(themeId, memberId, rating);
    }

    @GetMapping("/api/review/{themeId}")
    public List<ReviewDto> getReviews(@PathVariable Long themeId) {
        List<Review> result = reviewRepository.findByThemeWithCon(themeId);
        return result.stream()
                .map(ReviewDto::new)
                .collect(toList());
    }

    @GetMapping("/api/theme/{themeId}/member/{memberId}")
    public RatingResponse fetchThemeRatingOfUser(@PathVariable Long themeId, @PathVariable Long memberId) {
        return reviewService.fetchThemeRatingOfUser(themeId, memberId);
    }
}
