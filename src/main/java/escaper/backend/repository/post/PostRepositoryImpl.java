package escaper.backend.repository.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.entity.post.Post;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static escaper.backend.entity.comment.QComment.comment;
import static escaper.backend.entity.member.QMember.member;
import static escaper.backend.entity.post.QPost.post;
import static escaper.backend.entity.theme.QTheme.theme;


@RequiredArgsConstructor
@Slf4j
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public Post fetchPost(Long id) {
        return queryFactory.selectFrom(post)
                .where(post.id.eq(id))
                .leftJoin(post.member, member).fetchJoin()
                .leftJoin(post.comments, comment).fetchJoin()
                .leftJoin(post.theme, theme).fetchJoin()
                .fetchOne();
    }

    @Override
    public Page<Post> findPagePost(Pageable pageable) {
        List<Post> results = queryFactory
                .selectFrom(post)
                .orderBy(post.createDate.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        long total = results.size();
        return new PageImpl<>(results, pageable, total);
    }

    @Override
    public Page<Post> findPostWithTheme(Pageable pageable) {
        List<Post> posts = queryFactory
                .selectFrom(post)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
        return new PageImpl<>(posts, pageable, posts.size());

    }
}
