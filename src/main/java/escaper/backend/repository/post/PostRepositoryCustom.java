package escaper.backend.repository.post;

import escaper.backend.entity.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PostRepositoryCustom {

    List<PostResponseDto> findPagePost();
}
