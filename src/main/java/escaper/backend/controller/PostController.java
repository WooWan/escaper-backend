package escaper.backend.controller;

import escaper.backend.entity.CreatePostRequest;
import escaper.backend.entity.CreatePostResponse;
import escaper.backend.entity.Post;
import escaper.backend.entity.PostResponseDto;
import escaper.backend.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/")
    private List<PostResponseDto> getPosts() {
        List<Post> allPosts = postService.getAllPosts();
        return allPosts.stream()
                .map(post -> new PostResponseDto(post))
                .collect(Collectors.toList());
    }

    @PostMapping("/register")
    public CreatePostResponse savePost(@RequestBody @Valid CreatePostRequest request) {
        Post newPost = request.toEntity();
        Long id = postService.savePost(newPost);
        return new CreatePostResponse(id);
    }

}
