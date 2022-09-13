package escaper.backend.entity.post;

import escaper.backend.dto.post.PostUpdateRequest;
import escaper.backend.entity.BaseTimeEntity;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.UpdatePostRequestDto;
import escaper.backend.entity.comment.Comment;
import escaper.backend.entity.theme.Theme;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Member member;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    private String title;
    private String content;

    private String imageURL;
    private LocalDate appointmentDate;
    private Integer views;
    private Integer participation;

    public Post(String title, String content, Member member, LocalDate appointmentDate, Integer views, Integer participation) {
        this.title = title;
        this.content = content;
        this.member = member;
        this.appointmentDate = appointmentDate;
        this.views = views;
        this.participation = participation;
    }


    public void changeTitle(String title) {
        this.title = title;
    }


    public void changeContent(String content) {
        this.content = content;
    }

    public static Post createPost(String title, String content, Member member, LocalDate appointmentDate, Theme theme) {
        Post post = new Post(title, content, member, appointmentDate, 0, 1);
        post.addTheme(theme);
        return post;
    }

    public void addTheme(Theme theme) {
        this.theme = theme;
        theme.getPosts().add(this);
    }

    public void registerPost(Member member){
        this.member = member;
    }

    public void updatePost(PostUpdateRequest request, Theme theme) {
        this.title = request.getTitle();
        this.content = request.getContent();
        this.appointmentDate = request.getAppointmentDate();
        this.participation = request.getParticipation();
        this.theme = theme;
    }

    @Builder
    public Post(String title, String content,Integer participation, Integer views, LocalDate appointmentDate) {
        Assert.hasText(title, "title must now be null");
        Assert.hasText(content, "content must now be null");
        Assert.notNull(participation, "participation must now be null");
        Assert.notNull(appointmentDate, "appointmentDate must now be null");
        this.title = title;
        this.content = content;
        this.participation = participation;
        this.views= views;
        this.appointmentDate = appointmentDate;
    }
}
