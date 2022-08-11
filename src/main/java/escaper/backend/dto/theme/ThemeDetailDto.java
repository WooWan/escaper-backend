package escaper.backend.dto.theme;

import escaper.backend.entity.theme.Theme;
import lombok.Data;

@Data
public class ThemeDetailDto {

    private Long id;
    private String name;
    private String genre;
    private Integer timeLimitation;
    private Integer appropriatedPeople;
    private Double limitation;
    private Double rate;
    private Integer totalTime;
    private Integer cost;
    private String imageURL;

    public ThemeDetailDto(Theme theme) {
        id = theme.getId();
        name = theme.getName();
        genre = theme.getGenre();
        timeLimitation = theme.getTimeLimitation();
        appropriatedPeople = theme.getAppropriatedPeople();
        limitation = theme.getLimitation();
        rate = theme.getRate();
        totalTime = theme.getTotalTime();
        cost = theme.getCost();
        imageURL = theme.getImageURL();

    }
}

