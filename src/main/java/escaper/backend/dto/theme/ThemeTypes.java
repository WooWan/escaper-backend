package escaper.backend.dto.theme;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ThemeTypes {

    private Long id;
    private String genre;

    @QueryProjection
    public ThemeTypes(Long id, String genre) {
        this.id = id;
        this.genre = genre;
    }
}
