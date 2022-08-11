package escaper.backend.entity.post;

import escaper.backend.dto.theme.ThemeDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private LocalDate appointmentDate;
    private int views;
    private int participation;
    private ThemeDto themeDto;

    public PostDto(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.appointmentDate = post.getAppointmentDate();
        this.views = post.getViews();
        this.participation = post.getParticipation();
    }
}
