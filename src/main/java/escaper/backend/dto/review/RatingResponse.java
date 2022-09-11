package escaper.backend.dto.review;

import lombok.Builder;
import lombok.Data;

@Data
public class RatingResponse {
    private Double memberRating;

    @Builder
    public RatingResponse(Double memberRating) {
        this.memberRating = memberRating;
    }
}
