package escaper.backend.entity.comment;

import escaper.backend.entity.post.Post;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    public Post post;

    public String content;

    public void saveComment(String comment) {
        this.content = comment;
    }

    public void addPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }
}
