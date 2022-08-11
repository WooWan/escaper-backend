package escaper.backend.controller;

import escaper.backend.entity.review.CreateReview;
import escaper.backend.entity.review.Review;
import escaper.backend.entity.review.ReviewDto;
import escaper.backend.repository.review.ReviewRepository;
import escaper.backend.service.ReviewService;
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

    @PostMapping("/api/review")
    public Long registerReview(@RequestBody @Valid CreateReview reviewDto) {
        return reviewService.savePost(reviewDto);
    }

    @GetMapping("/api/review/{themeId}")
    public List<ReviewDto> getReviews(@PathVariable Long themeId) {
        List<Review> result = reviewRepository.findByThemeId(themeId);
        return result.stream()
                .map(ReviewDto::new)
                .collect(toList());
    }
}
