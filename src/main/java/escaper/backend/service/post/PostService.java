package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.UpdatePostRequestDto;
import escaper.backend.entity.post.PostResponse;
import escaper.backend.entity.theme.Theme;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.repository.theme.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;
    private final ThemeRepository themeRepository;

    @Transactional
    public Long savePost(CreatePostRequest request) {
        Theme findTheme = themeRepository.findByName(request.getThemeName());
        Post newPost = PostConverter.toPost(request);
        newPost.addTheme(findTheme);
        return postRepository.save(newPost).getId();
    }

    public Page<PostResponse> getPostsPaging(Pageable pageable) {
        Page<Post> posts = postRepository.findPagePost(pageable);
        return posts.map(PostResponse::new);
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

    public PostResponse fetchPost(Long id) {
        Post post = postRepository.fetchPost(id);
        return PostConverter.toPostResponse(post);
    }
}
