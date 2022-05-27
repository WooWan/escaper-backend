package escaper.backend.repository.post;

import escaper.backend.entity.post.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface PostRepositoryCustom {

    Page<Post> findPagePost(Pageable pageable);

    Page<Post> findPostWithTheme(Pageable pageable);
}
