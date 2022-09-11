package escaper.backend.entity.review;

import escaper.backend.dto.member.MemberResponse;
import escaper.backend.service.member.MemberConverter;
import lombok.Data;

@Data
public class ReviewDto {

    private Long reviewId;
    private MemberResponse memberResponse;
    private String content;
    private Double rate;
    private Long themeId;
    private Integer likes;

    public ReviewDto(Review review) {
        reviewId = review.getId();
        memberResponse = MemberConverter.toMemberResponse(review.getMember());
        content = review.getContent();
        rate = review.getRating();
        likes = review.getLikes();
        themeId = review.getTheme().getId();
    }
}
