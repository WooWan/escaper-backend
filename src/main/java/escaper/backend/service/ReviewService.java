package escaper.backend.service;

import escaper.backend.entity.review.CreateReview;
import escaper.backend.entity.review.Review;
import escaper.backend.repository.review.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Transactional
    public Long savePost(CreateReview reviewDto) {
        Review review = reviewDto.toEntity();
        Double rate = review.getRate();
        Double reviewUnit = 0.5;
        if (rate % reviewUnit != 0) {
            throw new IllegalArgumentException("평점은 0.5 단위 입니다.");
        }
        reviewRepository.save(review);
        return review.getId();
    }

}
