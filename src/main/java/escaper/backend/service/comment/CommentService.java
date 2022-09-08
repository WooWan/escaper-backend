package escaper.backend.service.comment;

import escaper.backend.dto.comment.CommentRequest;
import escaper.backend.dto.comment.CreateCommentRequest;
import escaper.backend.entity.comment.Comment;
import escaper.backend.entity.comment.CommentResponse;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.post.Post;
import escaper.backend.error.exception.CommentException;
import escaper.backend.repository.comment.CommentRepository;
import escaper.backend.repository.post.PostRepository;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveComment(Long postId, CreateCommentRequest createCommentRequest) {
        Optional<Post> result = postRepository.findById(postId);
        Post findPost = result.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다"));

        String memberId = createCommentRequest.getMemberId();
        Member findMember = memberRepository.findByUserId(memberId);

        Comment comment = new Comment();
        comment.addPost(findPost);
        comment.saveComment(createCommentRequest.getContent());
        comment.registerComment(findMember);
        return commentRepository
                .save(comment)
                .getId();
    }

    public List<CommentResponse> getPostComments(Long postId) {
        return commentRepository.getCommentsByPost(postId)
                .stream()
                .map(CommentConverter::toCommentResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void updateComment(Long commentId, Long postId, CommentRequest commentRequest) {
        Comment findComment = commentRepository.findById(commentId)
                .orElseThrow(() -> CommentException.notFoundComment(commentId));
        findComment.updateComment(commentRequest.getContent());
    }
}
