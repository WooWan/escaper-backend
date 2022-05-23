package escaper.backend.repository.post;

import escaper.backend.entity.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface PostRepositoryCustom {

    Page<PostResponseDto> findPagePost(Pageable pageable);
}
