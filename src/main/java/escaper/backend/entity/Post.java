package escaper.backend.entity;

import escaper.backend.entity.theme.Theme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;
    private String content;

    private String imageURL;
    private LocalDate appointmentDate;
    private int views;
    private int participation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "theme_id")
    private Theme theme;

    public Post(String title, String content, User user, Theme theme) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.theme = theme;
    }

    public void updatePost(UpdatePostRequestDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
