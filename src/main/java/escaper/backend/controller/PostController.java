package escaper.backend.controller;

import escaper.backend.entity.*;
import escaper.backend.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    private List<PostResponseDto> getPosts() {
        List<Post> allPosts = postService.getAllPosts();
        log.info("get Posts {} ", allPosts);
        return allPosts.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/post/{id}")
    private PostResponseDto getPost(@PathVariable Long id) {
        Post post = postService.getPost(id).orElseThrow(IllegalArgumentException::new);
        return new PostResponseDto(post.getTitle(), post.getContent());
    }

    @PostMapping("/post")
    private CreatePostResponse savePost(@RequestBody @Valid CreatePostRequest request) {
        log.info("post is hitted");
        Post newPost = request.toEntity();
        Long id = postService.savePost(newPost);
        return new CreatePostResponse(id);
    }

    @PutMapping("/post/{id}")
    private UpdatePostResponseDto updatePost(@PathVariable Long id, @RequestBody @Valid UpdatePostRequestDto request) {
        postService.update(id, request);
        Post updatedPost = postService.getPost(id).orElseThrow(IllegalAccessError::new);
        return new UpdatePostResponseDto(updatedPost.getTitle(), updatedPost.getContent());
    }

    @DeleteMapping("/post/{id}")
    private ResponseEntity<Long> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }
}
