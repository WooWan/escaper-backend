package escaper.backend.dto.theme;

import com.querydsl.core.annotations.QueryProjection;
import escaper.backend.entity.theme.Theme;
import lombok.Builder;
import lombok.Data;

@Data
public class ThemeDetailDto {

    private Long id;
    private String name;
    private String genre;
    private Integer timeLimitation;
    private Integer appropriatedPeople;
    private Double rate;
    private Integer cost;
    private String imageURL;

    private String cafeName;

    @QueryProjection
    public ThemeDetailDto(Long id, String name, String genre, Integer timeLimitation, Integer appropriatedPeople, Double rate, Integer cost, String imageURL, String cafeName) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.timeLimitation = timeLimitation;
        this.appropriatedPeople = appropriatedPeople;
        this.rate = rate;
        this.cost = cost;
        this.imageURL = imageURL;
        this.cafeName = cafeName;
    }
}

