package escaper.backend.entity;

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
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @OneToMany(mappedBy = "post")
    private List<ThemePost> themeList = new ArrayList<>();

    private String title;
    private String content;

    private String imageURL;
    private LocalDate appointmentDate;
    private int views;
    private int participation;

    public Post(String title, ThemePost... themePosts) {
        this.title = title;
        for (ThemePost themePost : themePosts) {
            themePost.setPost(this);
        }
        this.themeList = Stream.of(themePosts).collect(Collectors.toList());
    }


    public void changeTitle(String title) {
        this.title = title;
    }

    public void addTheme(Theme theme) {
//        ThemePost themePost = new ThemePost(theme, this);
//        themeList.add(themePost);
//        theme.getPostList().add(themePost);
//        themePostList.add(theme);
//        theme.setPost(this);
    }
    public void changeContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public static Post createPost(String title, String content, User user, Theme... themeList) {
        Post post = new Post();
        post.changeTitle(title);
        post.changeContent(content);
        post.setUser(user);
        ThemePost themePost1 = new ThemePost();
        for (Theme theme : themeList) {
            post.addTheme(theme);
        }
        return post;

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
