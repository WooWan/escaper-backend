package escaper.backend.dto.post;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreatePostDto {

    private String memberId;
    private String title;
    private String content;
    private Integer participation;
    private LocalDate date;
    private Integer views;
    private String themeName;

    @Builder
    public CreatePostDto(String memberId, String title, String content, Integer participation, LocalDate date, Integer views, String themeName) {
        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.participation = participation;
        this.date = date;
        this.views = views;
        this.themeName = themeName;
    }
}
