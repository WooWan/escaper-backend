package escaper.backend.entity.theme;

import escaper.backend.entity.post.Post;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.review.Review;
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

    @OneToMany(mappedBy = "theme")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "theme")
    public List<Review> reviews = new ArrayList<>();
    private String name;
    private String genre;
    private Integer timeLimitation;
    private Integer appropriatedPeople;
    private Double limitation;
    private Double rate;
    private Integer totalTime;
    private Integer cost;
    private String imageURL;

    public void setName(String name) {
        this.name = name;
    }

    public Theme(String name) {
        this.name = name;
    }

    public Theme(String name, Cafe cafe, String genre) {
        this.name = name;
        this.cafe = cafe;
        this.genre = genre;
    }

    public static Theme createTheme(String name) {
        Theme theme = new Theme();
        theme.setName(name);
        return theme;
    }
}
