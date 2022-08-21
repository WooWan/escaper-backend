package escaper.backend.controller;

import escaper.backend.entity.comment.Comment;
import escaper.backend.entity.comment.CommentDto;
import escaper.backend.repository.comment.CommentRepository;
import escaper.backend.service.CommentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final CommentRepository commentRepository;

    @GetMapping("/api/comment")
    public List<CommentDto> getComments(@RequestParam Long postId) {
        List<Comment> result = commentRepository.getCommentsByPost(postId);
        log.info("comments:  {}", result);
        return result
                .stream()
                .map(CommentDto::new)
                .collect(Collectors.toList());
    }

    @PostMapping("/api/comment")
    public Long saveComment(@RequestParam Long postId, @RequestBody String request) {
        return commentService.saveComment(postId, request);
    }

}
