package escaper.backend.entity.review;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Builder
public class Review {

    @Id @GeneratedValue
    private Long id;

    private Double rate;
    private String comment;
}
