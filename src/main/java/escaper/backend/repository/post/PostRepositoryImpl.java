package escaper.backend.repository.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.entity.Post;
import escaper.backend.entity.PostResponseDto;
import escaper.backend.entity.QPostResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import static escaper.backend.entity.QPost.post;
import static escaper.backend.entity.theme.QTheme.theme;

@RequiredArgsConstructor
@Slf4j
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PostResponseDto> findPagePost() {
        List<PostResponseDto> results = queryFactory
                .select(new QPostResponseDto(
                        post.id,
                        post.title,
                        post.content,
                        theme.name
                ))
                .from(post)
                .leftJoin(post.theme, theme)
                .fetch();
        long total = results.size();
        return results;
    }
}
