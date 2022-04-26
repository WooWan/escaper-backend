package escaper.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Builder
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Post {

    @GeneratedValue
    @Id
    private Long id;

    private String title;
    private String content;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void updatePost(UpdatePostRequestDto request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}
