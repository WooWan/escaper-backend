package escaper.backend.dto.post;

import escaper.backend.entity.post.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreatePostRequest {

    private String title;
    private String content;
    private Integer participation;
    private LocalDate appointmentDate;
    private List<Long> themes;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .participation(participation)
                .appointmentDate(appointmentDate)
                .build();
    }
}
