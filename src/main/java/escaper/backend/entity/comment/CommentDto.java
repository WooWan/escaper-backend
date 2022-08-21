package escaper.backend.entity.comment;

import lombok.Data;

@Data
public class CommentDto {

    private Long id;
    private String content;

    public CommentDto(Comment comment) {
        id = comment.getId();
        content = comment.getContent();
    }
}
