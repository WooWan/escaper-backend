package escaper.backend.dto.review;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreateRating {

    private Double rating;

    public CreateRating(Double rating) {
        this.rating = rating;
    }
}
