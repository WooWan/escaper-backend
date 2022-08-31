package escaper.backend.service.post;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.UpdatePostRequestDto;
import escaper.backend.entity.post.PostResponse;
import escaper.backend.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostService {

    private final PostRepository postRepository;

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

    public PostResponse fetchPost(Long id) {
        Post post = postRepository.fetchPost(id);
        return PostConverter.toPostResponse(post);
    }
}
