package escaper.backend.entity.theme;

import escaper.backend.entity.ThemePost;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.Image;
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
    private List<ThemePost> postList = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    private String name;

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
