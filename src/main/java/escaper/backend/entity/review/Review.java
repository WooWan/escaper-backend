package escaper.backend.entity.review;

import escaper.backend.entity.member.Member;
import escaper.backend.entity.theme.Theme;
import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Review {

    @Id @GeneratedValue
    private Long id;

    private Double rating;
    private String content;
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public Review(Double rating, String content) {
        this.rating = rating;
        this.content = content;
        this.likes = 0;
    }

    public void addTheme(Theme theme) {
        this.theme = theme;
        theme.getReviews().add(this);
    }

    public void addMember(Member member) {
        this.member = member;
        member.getReviews().add(this);
    }

    public void rateTheme(Double rating) {
        this.rating = rating;
    }
}
