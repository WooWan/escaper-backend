package escaper.backend.entity;

import escaper.backend.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreatePostRequest {

    private String title;
    private String content;
    private Integer participation;
    private LocalDate appointmentDate;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .participation(participation)
                .appointmentDate(appointmentDate)
                .build();
    }
}
