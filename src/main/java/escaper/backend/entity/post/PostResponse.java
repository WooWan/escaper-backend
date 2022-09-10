package escaper.backend.entity.post;

import escaper.backend.dto.member.MemberResponse;
import escaper.backend.dto.theme.ThemeResponse;
import escaper.backend.service.member.MemberConverter;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PostResponse {

    private MemberResponse memberResponse;
    private Long postId;
    private String title;
    private String content;
    private LocalDateTime createdDate;
    private LocalDate appointmentDate;
    private Integer views;
    private Integer participation;
    private ThemeResponse themeResponse;

    @Builder
    public PostResponse(Post post) {
        this.memberResponse = MemberConverter.toMemberResponse(post.getMember());
        this.postId = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.createdDate = post.getCreateDate();
        this.appointmentDate = post.getAppointmentDate();
        this.views = post.getViews();
        this.participation = post.getParticipation();
        this.themeResponse = new ThemeResponse(post.getTheme());
    }
}
