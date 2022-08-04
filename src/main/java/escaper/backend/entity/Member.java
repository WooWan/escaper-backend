package escaper.backend.entity;

import escaper.backend.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Member {

    @GeneratedValue
    @Id
    @Column(name = "user_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "member")
    private List<Post> postList = new ArrayList<>();

    public Member(String name) {
        this.name = name;
    }
}
