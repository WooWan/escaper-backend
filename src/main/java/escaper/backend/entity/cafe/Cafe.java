package escaper.backend.entity.cafe;

import escaper.backend.entity.theme.Theme;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cafe {

    @Id
    @GeneratedValue
    @Column(name = "cafe_id")
    private Long id;

    @OneToMany(mappedBy = "cafe")
    private List<Theme> themeList = new ArrayList<>();

    private String name;
    private String phoneNumber;
    private Double rating;

    @Embedded
    private Address address;

    @Builder
    public Cafe(String name,String phoneNumber, Address address, Double rating) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.rating = rating;
    }

    public Cafe(String name) {
        this.name = name;
    }

    public void updateRating(double rating) {
        this.rating = rating;

    }
}
