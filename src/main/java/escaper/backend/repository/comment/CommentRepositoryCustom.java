package escaper.backend.repository.comment;

import escaper.backend.entity.comment.Comment;

import java.util.List;

public interface CommentRepositoryCustom {

    List<Comment> getCommentsByPost(Long id);
}
