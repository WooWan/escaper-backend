package escaper.backend.dto.review;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewResponse<T> {

    private int count;
    private double averageRating;
    private T data;
}
