package escaper.backend.dto.review;

import lombok.Builder;
import lombok.Data;

@Data
public class RatingResponse {
    private Double userRating;

    @Builder
    public RatingResponse(Double userRating) {
        this.userRating = userRating;
    }
}
