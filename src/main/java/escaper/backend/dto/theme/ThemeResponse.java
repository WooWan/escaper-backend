package escaper.backend.dto.theme;

import escaper.backend.entity.theme.Theme;
import lombok.Data;

@Data
public class ThemeResponse {

    private Long themeId;
    private String cafeName;
    private String name;
    private String genre;
    private Double rating;
    private String imageURL;

    public ThemeResponse(Theme theme) {
        this.themeId = theme.getId();
        this.cafeName = theme.getCafe().getName();
        this.name = theme.getName();
        this.genre = theme.getGenre();
        this.rating = theme.getRating();
        this.imageURL = theme.getImageURL();
    }
}
