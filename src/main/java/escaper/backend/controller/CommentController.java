package escaper.backend.controller;

import escaper.backend.dto.comment.CreateCommentRequest;
import escaper.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/post/{postId}/comment")
    public Integer saveComment(@PathVariable Long postId, @RequestBody CreateCommentRequest request) {
        return commentService.saveComment(postId, request);
    }

}
