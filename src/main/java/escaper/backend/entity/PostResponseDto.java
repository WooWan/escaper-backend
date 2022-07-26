package escaper.backend.entity;

import escaper.backend.entity.post.Post;
import escaper.backend.dto.theme.ThemeDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import static java.util.stream.Collectors.*;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private List<ThemeDto> themeList;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.themeList = post.getThemeList().stream()
                .map(ThemeDto::new)
                .collect(toList());
    }

}
