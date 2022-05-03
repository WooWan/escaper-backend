package escaper.backend.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
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

}
