package escaper.backend.entity;

import com.querydsl.core.annotations.QueryProjection;
import escaper.backend.entity.theme.ThemeDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostResponseDto {

    private Long id;
    private String title;
    private String content;
    private String themeName;

    private List<ThemeDto> themeList;

    @QueryProjection
    public PostResponseDto(Long id, String title, String content, String themeName) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.themeName = themeName;
    }


}
