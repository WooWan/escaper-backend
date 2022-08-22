package escaper.backend.entity.review;

import lombok.Getter;

@Getter
public class CreateReview {

    private String content;

    public Review toEntity() {
        return Review.builder()
                .content(content)
                .rating(0.0)
                .likes(0)
                .build();
    }
}
