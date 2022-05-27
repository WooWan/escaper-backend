package escaper.backend.controller;

import escaper.backend.entity.*;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.post.PostDto;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Getter
@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;
    private final PostRepository postRepository;

    @GetMapping("/api/posts")
    @ResponseStatus(HttpStatus.OK)
    private Page<PostDto> getPosts(Pageable pageable) {
        Page<Post> posts= postRepository.findPagePost(pageable);
        return posts.map(PostDto::new);
    }


//    @GetMapping("/api/post/{id}")
//    private PostResponseDto getPost(@PathVariable Long id) {
//        Post post = postService.getPost(id).orElseThrow(IllegalArgumentException::new);
//        return new PostResponseDto(post.getTitle(), post.getContent());
//    }

    @PostMapping("/api/post")
    private CreatePostResponse savePost(@RequestBody @Valid CreatePostRequest request) {
        log.info("request: {}", request);
        Post newPost = request.toEntity();
        Long id = postService.savePost(newPost);
        return new CreatePostResponse(id);
    }

    @PutMapping("/api/post/{id}")
    private UpdatePostResponseDto updatePost(@PathVariable Long id, @RequestBody @Valid UpdatePostRequestDto request) {
        postService.update(id, request);
        Post updatedPost = postService.getPost(id).orElseThrow(IllegalAccessError::new);
        return new UpdatePostResponseDto(updatedPost.getTitle(), updatedPost.getContent());
    }

    @DeleteMapping("/api/post/{id}")
    private ResponseEntity<Long> deletePost(@PathVariable Long id) {
        postService.delete(id);
        return ResponseEntity.ok(id);
    }
}
