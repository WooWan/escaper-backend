package escaper.backend.entity.review;

import escaper.backend.entity.member.Member;
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
    private Integer likes;

    @ManyToOne
    @JoinColumn(name = "theme_id")
    private Theme theme;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;

    public void addTheme(Theme theme) {
        this.theme = theme;
        theme.getReviews().add(this);
    }

    public void addMember(Member member) {
        this.member = member;
        member.addReview(this);
    }

    public void rateTheme(Double rating) {
        this.rate = rating;
    }
}
