package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.UpdatePostRequestDto;
import escaper.backend.entity.theme.Theme;
import escaper.backend.error.exception.ThemeException;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.repository.theme.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ThemeRepository themeRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Transactional
    public Long savePost(CreatePostRequest request) {
        Post newPost = PostConverter.toPost(request);
        return postRepository.save(newPost).getId();
    }


    @Transactional
    public void update(Long id, UpdatePostRequestDto request) {
        Post findPost = postRepository.findById(id).orElseThrow(IllegalAccessError::new);
        findPost.updatePost(request);
    }

    @Transactional
    public void delete(Long id) {
        postRepository.deleteById(id);
    }

}
