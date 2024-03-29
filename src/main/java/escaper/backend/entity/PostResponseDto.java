package escaper.backend.entity;

import escaper.backend.entity.comment.CommentResponse;
import escaper.backend.entity.post.Post;
import escaper.backend.dto.theme.ThemeResponse;
import escaper.backend.service.comment.CommentConverter;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import static java.util.stream.Collectors.*;

@Data
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private List<CommentResponse> comments;
    private ThemeResponse themeResponse;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.themeResponse = new ThemeResponse(post.getTheme());
        this.comments = post.getComments().stream()
                .map(CommentConverter::toCommentResponse)
                .collect(toList());
    }

}
