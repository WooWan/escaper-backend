package escaper.backend.dto.theme;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class ThemeDetailDto {

    private Long themeId;
    private String name;
    private String genre;
    private Integer timeLimitation;
    private Integer appropriatedPeople;
    private Double themeRating;
    private Integer cost;
    private String imageURL;

    private Long cafeId;
    private String cafeName;

    @QueryProjection
    public ThemeDetailDto(Long themeId, String name, String genre, Integer timeLimitation, Integer appropriatedPeople, Double themeRating, Integer cost, String imageURL, Long cafeId, String cafeName) {
        this.themeId = themeId;
        this.name = name;
        this.genre = genre;
        this.timeLimitation = timeLimitation;
        this.appropriatedPeople = appropriatedPeople;
        this.themeRating = themeRating;
        this.cost = cost;
        this.imageURL = imageURL;
        this.cafeId = cafeId;
        this.cafeName = cafeName;
    }
}

