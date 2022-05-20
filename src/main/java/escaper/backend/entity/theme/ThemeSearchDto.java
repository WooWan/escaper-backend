package escaper.backend.entity.theme;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ThemeSearchDto {

    private Long themeId;
    private String name;

    @QueryProjection
    public ThemeSearchDto(Long themeId, String name) {
        this.themeId = themeId;
        this.name = name;
    }
}
