package escaper.backend.entity.review;

import escaper.backend.entity.theme.Theme;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Review {

    @Id @GeneratedValue
    private Long id;

    private Double rate;
    private String content;
    private Integer like;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;
}
