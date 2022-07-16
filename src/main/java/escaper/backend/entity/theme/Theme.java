package escaper.backend.entity.theme;

import escaper.backend.entity.post.Post;
import escaper.backend.entity.cafe.Cafe;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Theme {

    @Id
    @GeneratedValue
    @Column(name = "theme_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe_id")
    private Cafe cafe;

    @ManyToMany(mappedBy = "themeList")
    private List<Post> postList = new ArrayList<>();

    private String name;
    private String genre;
    private Integer rate;
    private Integer totalTime;
    private Integer cost;
    private String imageURL;

    public void setName(String name) {
        this.name = name;
    }

    public Theme(String name) {
        this.name = name;
    }

    public Theme(String name, Cafe cafe) {
        this.name = name;
        this.cafe = cafe;
    }

    public static Theme createTheme(String name) {
        Theme theme = new Theme();
        theme.setName(name);
        return theme;
    }
}
