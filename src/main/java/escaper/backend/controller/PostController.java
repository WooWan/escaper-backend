package escaper.backend.controller;

import escaper.backend.dto.post.CreatePostDto;
import escaper.backend.dto.post.PostRequest;
import escaper.backend.entity.post.PostResponse;
import escaper.backend.oauth.entity.UserPrincipal;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.service.post.PostConverter;
import escaper.backend.service.post.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Getter
@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/api/posts")
    private Page<PostResponse> getPosts(Pageable pageable) {
        return postService.getPostsPaging(pageable);
    }

    @GetMapping("/api/post/{id}")
    private PostResponse fetchPost(@PathVariable Long id) {
        return postService.fetchPost(id);
    }

    @PostMapping("/api/post")
    public Long savePost(Authentication authentication, @AuthenticationPrincipal UserPrincipal userPrincipal, @RequestBody PostRequest postRequest) {
        User principal =(User) authentication.getPrincipal();
        String username = principal.getUsername();
        CreatePostDto createPostDto = PostConverter.toPostCreateDto(username, postRequest);

        return postService.savePost(createPostDto);
    }

    @DeleteMapping("/api/post/{id}")
    private ResponseEntity<Long> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }
}
