package escaper.backend.service;

import escaper.backend.entity.Post;
import escaper.backend.entity.UpdatePostRequestDto;
import escaper.backend.repository.PostRepository;
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

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Optional<Post> getPost(Long id) {
        return postRepository.findById(id);
    }

    @Transactional
    public Long savePost(Post post) {
        postRepository.save(post);
        return post.getId();
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
