package escaper.backend.entity.post;

import escaper.backend.dto.theme.ThemeResponse;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PostResponse {

    private Long postId;
    private String title;
    private String content;
    private LocalDate appointmentDate;
    private Integer views;
    private Integer participation;
    private ThemeResponse themeResponse;


    @Builder
    public PostResponse(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.appointmentDate = post.getAppointmentDate();
        this.views = post.getViews();
        this.participation = post.getParticipation();
        this.themeResponse = new ThemeResponse(post.getTheme());
    }
}
