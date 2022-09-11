package escaper.backend.dto.theme;

import com.querydsl.core.annotations.QueryProjection;
import escaper.backend.entity.cafe.Address;
import lombok.Data;

@Data
public class ThemeDetailDto {

    private Long themeId;
    private String name;
    private String genre;
    private String description;
    private Integer timeLimitation;
    private Double themeRating;
    private Integer cost;
    private String imageURL;
    private Long cafeId;
    private String phoneNumber;
    private String cafeName;
    private Address address;

    @QueryProjection
    public ThemeDetailDto(Long themeId, String name, String genre, String description, Integer timeLimitation, Double themeRating, Integer cost, String imageURL, Long cafeId, String phoneNumber, String cafeName, Address address) {
        this.themeId = themeId;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.timeLimitation = timeLimitation;
        this.themeRating = themeRating;
        this.cost = cost;
        this.imageURL = imageURL;
        this.cafeId = cafeId;
        this.phoneNumber = phoneNumber;
        this.cafeName = cafeName;
        this.address = address;
    }
}

