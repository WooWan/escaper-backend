package escaper.backend.service;

import escaper.backend.dto.comment.CreateCommentRequest;
import escaper.backend.entity.commnet.Comment;
import escaper.backend.entity.post.Post;
import escaper.backend.repository.comment.CommentRepository;
import escaper.backend.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Transactional
    public Integer saveComment(Long postId, CreateCommentRequest request) {
        Optional<Post> result = postRepository.findById(postId);
        Post findPost = result.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다"));

        Comment comment = new Comment();
        comment.addPost(findPost);
        comment.saveComment(request);
        return commentRepository.save(comment)
                .getId();
    }
}
