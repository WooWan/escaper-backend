package escaper.backend.controller;

import escaper.backend.dto.comment.CommentRequest;
import escaper.backend.dto.comment.CreateCommentRequest;
import escaper.backend.entity.comment.CommentResponse;
import escaper.backend.repository.comment.CommentRepository;
import escaper.backend.service.comment.CommentConverter;
import escaper.backend.service.comment.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @GetMapping("/api/comment")
    public List<CommentResponse> getComments(@RequestParam Long postId) {
        return commentService.getPostComments(postId);
    }

    @PostMapping("/api/comment")
    public Long saveComment(Authentication authentication, @RequestParam Long postId, @RequestBody CommentRequest commentRequest) {
        User principal =(User) authentication.getPrincipal();
        String username = principal.getUsername();
        CreateCommentRequest createCommentDto = CommentConverter.toCommentCreateRequest(username, commentRequest);

        return commentService.saveComment(postId, createCommentDto);
    }

}
