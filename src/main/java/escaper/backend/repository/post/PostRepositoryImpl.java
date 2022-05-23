package escaper.backend.repository.post;

import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.entity.PostResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public Page<PostResponseDto> findPagePost(Pageable pageable) {
        return null;
    }
}
