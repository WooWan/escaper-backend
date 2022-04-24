package escaper.backend.controller;

import escaper.backend.entity.CreatePostRequest;
import escaper.backend.entity.CreatePostResponse;
import escaper.backend.entity.Post;
import escaper.backend.entity.PostResponseDto;
import escaper.backend.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Slf4j
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    private List<PostResponseDto> getPosts() {
        List<Post> allPosts = postService.getAllPosts();
        log.info("get Posts {} ", allPosts);
        return allPosts.stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/register")
    public CreatePostResponse savePost(@RequestBody @Valid CreatePostRequest request) {
        Post newPost = request.toEntity();
        Long id = postService.savePost(newPost);
        return new CreatePostResponse(id);
    }

}
