package escaper.backend.dto.theme;

import escaper.backend.dto.cafe.CafeResponse;
import escaper.backend.entity.theme.Theme;
import escaper.backend.service.cafe.CafeConverter;
import lombok.Getter;

@Getter
public class ThemeResponse {

    private Long themeId;
    private String name;
    private String genre;
    private Double rating;
    private String imageURL;
    private CafeResponse cafeResponse;

    public ThemeResponse(Theme theme) {
        this.themeId = theme.getId();
        this.name = theme.getName();
        this.genre = theme.getGenre();
        this.rating = theme.getRating();
        this.imageURL = theme.getImageURL();
        this.cafeResponse = CafeConverter.toCafeResponse(theme.getCafe());
    }
}
