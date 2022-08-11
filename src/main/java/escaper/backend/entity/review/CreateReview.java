package escaper.backend.entity.review;

import lombok.Getter;
import org.springframework.lang.Nullable;

@Getter
public class CreateReview {

    private Long memberId;
    private Double rate;
    @Nullable
    private String content;

    public Review toEntity() {
        return Review.builder()
                .rate(rate)
                .content(content)
                .like(0)
                .build();
    }
}
