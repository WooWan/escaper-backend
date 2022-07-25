package escaper.backend.controller;

import escaper.backend.entity.review.CreateReviewDto;
import escaper.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class ReviewController {

    private final ReviewService reviewService;


    @PostMapping("/api/review")
    public Long registerReview(@RequestBody @Valid CreateReviewDto reviewDto) {
        return reviewService.savePost(reviewDto);

    }
}
