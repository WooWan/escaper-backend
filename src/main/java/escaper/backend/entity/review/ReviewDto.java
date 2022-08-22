package escaper.backend.entity.review;

import lombok.Data;

@Data
public class ReviewDto {

    private Long reviewId;
    private String content;
    private Double rate;
    private Long themeId;
    private Integer likes;

    public ReviewDto(Review review) {
        reviewId = review.getId();
        content = review.getContent();
        rate = review.getRating();
        likes = review.getLikes();
        themeId = review.getTheme().getId();
    }
}
