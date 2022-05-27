package escaper.backend.entity.post;

import escaper.backend.entity.theme.ThemeDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private LocalDate appointmentDate;
    private int views;
    private int participation;
    private List<ThemeDto> themeList;

    public PostDto(Post post) {
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.appointmentDate = post.getAppointmentDate();
        this.views = post.getViews();
        this.participation = post.getParticipation();
        this.themeList = post.getThemeList().stream()
                .map(ThemeDto::new)
                .collect(Collectors.toList());
    }
}
