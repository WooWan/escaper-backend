package escaper.backend.dto.cafe;

import escaper.backend.dto.theme.ThemeDto;
import escaper.backend.entity.cafe.Cafe;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CafeDto {

    private Long id;
    private String name;

    private List<ThemeDto> themes;

    public CafeDto(Cafe cafe) {
        id = cafe.getId();
        name = cafe.getName();
        themes = cafe.getThemeList().stream()
                .map(ThemeDto::new)
                .collect(Collectors.toList());
    }
}
