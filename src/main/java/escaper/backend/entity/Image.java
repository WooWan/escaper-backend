package escaper.backend.entity;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class Image {

    @Id
    @GeneratedValue
    @Column(name = "image_id")
    private Long id;

    private String imageURL;

    @OneToOne(mappedBy = "image", fetch = FetchType.LAZY)
    private Theme theme;

}
