package escaper.backend.service.comment;

import escaper.backend.dto.comment.CommentRequest;
import escaper.backend.dto.comment.CreateCommentRequest;
import escaper.backend.entity.comment.Comment;
import escaper.backend.entity.comment.CommentResponse;

public class CommentConverter {

    public static CreateCommentRequest toCommentCreateRequest(String memberId, CommentRequest commentRequest) {
        return CreateCommentRequest.builder()
                .memberId(memberId)
                .content(commentRequest.getContent())
                .build();
    }

    public static CommentResponse toCommentResponse(Comment comment) {
        return CommentResponse.builder()
                .comment(comment)
                .build();
    }
}
