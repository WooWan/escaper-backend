package escaper.backend.entity.theme;

import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.Image;
import escaper.backend.entity.Post;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Theme {

    @Id
    @GeneratedValue
    @Column(name = "theme_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cafe")
    private Cafe cafe;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "theme")
    private Post post;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    private String name;

    public Theme(String name) {
        this.name = name;
    }

    public Theme(String name, Cafe cafe) {
        this.name = name;
        this.cafe = cafe;
    }
}
