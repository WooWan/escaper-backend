package escaper.backend.entity.cafe;

import escaper.backend.entity.theme.Theme;
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

    public Cafe(String name,String phoneNumber, Address address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public Cafe(String name) {
        this.name = name;
    }
}
