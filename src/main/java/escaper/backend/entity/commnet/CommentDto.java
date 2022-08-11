package escaper.backend.entity.commnet;

import lombok.Data;

@Data
public class CommentDto {

    private Integer id;
    private String content;

    public CommentDto(Comment comment) {
        id = comment.getId();
        content = comment.getContent();
    }
}
