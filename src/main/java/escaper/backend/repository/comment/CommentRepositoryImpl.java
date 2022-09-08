package escaper.backend.repository.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.entity.comment.Comment;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static escaper.backend.entity.comment.QComment.comment;
import static escaper.backend.entity.post.QPost.post;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Comment> getCommentsByPost(Long id) {
        return queryFactory.selectFrom(comment)
                .join(comment.post, post).fetchJoin()
                .where(comment.post.id.eq(id))
                .fetch();
    }

}
