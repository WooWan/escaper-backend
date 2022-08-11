package escaper.backend.entity.review;

import lombok.Data;

@Data
public class ReviewDto {

    private Long reviewId;
    private String content;
    private Double rate;
    private Long themeId;
    private Integer like;

    public ReviewDto(Review review) {
        reviewId = review.getId();
        content = review.getContent();
        rate = review.getRate();
        like = review.getLike();
        themeId = review.getTheme().getId();
    }
}
