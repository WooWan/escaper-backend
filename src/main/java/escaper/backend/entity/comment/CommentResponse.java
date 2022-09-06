package escaper.backend.entity.comment;

import escaper.backend.dto.member.MemberResponse;
import escaper.backend.service.comment.CommentConverter;
import escaper.backend.service.member.MemberConverter;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentResponse {

    private MemberResponse memberResponse;
    private Long id;
    private String content;
    private LocalDateTime createdDate;

    @Builder
    public CommentResponse(Comment comment) {
        this.memberResponse = MemberConverter.toMemberResponse(comment.getMember());
        this.id = comment.getId();
        this.content = comment.getContent();
        this.createdDate = comment.getCreateDate();
    }
}
