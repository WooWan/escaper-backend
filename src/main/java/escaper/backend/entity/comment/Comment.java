package escaper.backend.entity.comment;

import escaper.backend.entity.BaseTimeEntity;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.post.Post;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    private String content;

    public void saveComment(String comment) {
        this.content = comment;
    }

    public void addPost(Post post) {
        this.post = post;
        post.getComments().add(this);
    }

    public void registerComment(Member member) {
        this.member = member;
    }

    public void updateComment(String content) {
        this.content = content;
    }
}
