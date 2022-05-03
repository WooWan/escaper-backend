package escaper.backend.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class User {

    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToMany(mappedBy = "user")
    private List<Post> postList = new ArrayList<>();
}
