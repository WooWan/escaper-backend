package escaper.backend.entity.commnet;

import escaper.backend.dto.comment.CreateCommentRequest;
import escaper.backend.entity.post.Post;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    public Post post;

    public String content;

    public void saveComment(CreateCommentRequest request) {
        content = request.getContent();
    }

    public void addPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}
