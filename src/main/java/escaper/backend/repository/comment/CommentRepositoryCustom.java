package escaper.backend.repository.comment;

import escaper.backend.entity.commnet.Comment;

import java.util.List;

public interface CommentRepositoryCustom {

    List<Comment> getCommentsByPost(Long id);
}
