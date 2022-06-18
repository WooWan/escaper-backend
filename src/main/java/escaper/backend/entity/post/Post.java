package escaper.backend.entity.post;

import escaper.backend.entity.BaseTimeEntity;
import escaper.backend.entity.UpdatePostRequestDto;
import escaper.backend.entity.User;
import escaper.backend.entity.theme.Theme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "POST_THEME",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "theme_id"))
    private List<Theme> themeList = new ArrayList<>();

    private String title;
    private String content;

    private String imageURL;
    private LocalDate appointmentDate;
    private int views;
    private int participation;

    public Post(String title, String content, User user, LocalDate appointmentDate) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.appointmentDate = appointmentDate;
    }


    public void changeTitle(String title) {
        this.title = title;
    }


    public void changeContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Post createPost(String title, String content, User user, LocalDate appointmentDate, Theme... themeList) {
        Post post = new Post(title, content, user, appointmentDate);
        for (Theme theme : themeList) {
            post.addTheme(theme);
        }
        return post;
    }

    public void addTheme(Theme theme) {
        themeList.add(theme);
        theme.getPostList().add(this);
    }

//    public Post(String title, String content, User user, Theme theme) {
//        this.title = title;
//        this.content = content;
//        this.user = user;
//        this.theme = theme;
//    }

    public void updatePost(UpdatePostRequestDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
