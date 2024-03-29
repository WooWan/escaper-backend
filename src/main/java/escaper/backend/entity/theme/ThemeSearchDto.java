package escaper.backend.entity.theme;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ThemeSearchDto {

    private Long id;
    private String name;

    @QueryProjection
    public ThemeSearchDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
