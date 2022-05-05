package escaper.backend.entity;

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

    @ManyToOne
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
}
