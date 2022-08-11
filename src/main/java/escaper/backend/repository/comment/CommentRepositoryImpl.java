package escaper.backend.repository.comment;

import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.entity.commnet.Comment;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static escaper.backend.entity.commnet.QComment.comment;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Comment> getCommentsByPost(Long id) {
        return queryFactory.selectFrom(comment)
                .where(comment.post.id.eq(id))
                .fetch();
    }

}
