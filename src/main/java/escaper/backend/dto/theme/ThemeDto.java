package escaper.backend.dto.theme;

import escaper.backend.entity.theme.Theme;
import lombok.Data;

@Data
public class ThemeDto {

    private Long id;
    private String name;
    private String genre;
    private Double rate;
    private String imageURL;

    public ThemeDto(Theme theme) {
        this.id = theme.getId();
        this.name = theme.getName();
        this.genre = theme.getGenre();
        this.rate = theme.getRate();
        this.imageURL = theme.getImageURL();
    }
}
