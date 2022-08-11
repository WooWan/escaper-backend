package escaper.backend.repository.comment;

import escaper.backend.entity.commnet.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer>, CommentRepositoryCustom {
}
