package escaper.backend.controller;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.post.PostResponse;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.service.post.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Getter
@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/api/posts")
    @ResponseStatus(HttpStatus.OK)
    private Page<PostResponse> getPosts(Pageable pageable) {
        Page<Post> posts= postRepository.findPagePost(pageable);
        log.info("posts {}", posts);
        return posts.map(PostResponse::new);
    }

    @GetMapping("/api/post/{id}")
    private PostResponse fetchPost(@PathVariable Long id) {
        return postService.fetchPost(id);
    }

    @PostMapping("/api/post")
    public Long savePost(@RequestBody CreatePostRequest postRequest) {
        return postService.savePost(postRequest);
    }

    @DeleteMapping("/api/post/{id}")
    private ResponseEntity<Long> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }
}
