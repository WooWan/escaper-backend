package escaper.backend.entity.theme;

import lombok.Data;

@Data
public class ThemeDto {

    private Long id;
    private String name;

    public ThemeDto(Theme theme) {
        this.id = theme.getId();
        this.name = theme.getName();
    }
}
