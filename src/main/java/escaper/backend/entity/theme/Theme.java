package escaper.backend.entity.theme;

import escaper.backend.entity.post.Post;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.review.Review;
import lombok.Builder;
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
    @Column(length = 1000)
    private String description;
    private Integer timeLimitation;
    private Integer appropriatedPeople;
    private Double rating;
    private Integer cost;
    private String imageURL;

    public void setName(String name) {
        this.name = name;
    }

    public Theme(String name) {
        this.name = name;
    }

    @Builder
    public Theme(String name, Cafe cafe, String genre, String description, Integer timeLimitation, Integer appropriatedPeople
            , Double rating, Integer cost, String imageURL) {
        this.name = name;
        this.cafe = cafe;
        this.genre = genre;
        this.description = description;
        this.timeLimitation = timeLimitation;
        this.appropriatedPeople = appropriatedPeople;
        this.rating = rating;
        this.cost = cost;
        this.imageURL = imageURL;
    }

    public static Theme createTheme(String name) {
        Theme theme = new Theme();
        theme.setName(name);
        return theme;
    }

    public void updateRating(Double rating) {
        int reviewCount = reviews.size();
        Double previousRating = this.rating * reviewCount;
        this.rating = (previousRating + rating) / (reviewCount+1);
    }
}
