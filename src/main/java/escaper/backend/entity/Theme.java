package escaper.backend.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Theme {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cafe")
    private Cafe cafe;

    private String name;

}
