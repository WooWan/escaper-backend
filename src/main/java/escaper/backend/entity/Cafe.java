package escaper.backend.entity;

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

    @Embedded
    private Address address;

    public Cafe(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
