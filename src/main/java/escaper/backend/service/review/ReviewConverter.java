package escaper.backend.service.review;

import escaper.backend.dto.review.RatingResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReviewConverter {

    public static RatingResponse toRatingResponse( Double userRating) {
        return RatingResponse.builder()
                .userRating(userRating)
                .build();
    }
}
