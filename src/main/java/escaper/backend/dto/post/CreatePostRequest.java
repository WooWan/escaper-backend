package escaper.backend.dto.post;

import escaper.backend.entity.post.Post;
import escaper.backend.entity.theme.Theme;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CreatePostRequest {

    private String title;
    private String content;
    private Integer participation;
    private LocalDate date;
    private Integer views;
    private String themeName;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .participation(participation)
                .appointmentDate(date)
                .views(0)
                .build();
    }
}
