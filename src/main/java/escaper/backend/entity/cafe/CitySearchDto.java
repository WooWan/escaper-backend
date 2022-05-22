package escaper.backend.entity.cafe;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;

@Data
public class CitySearchDto {

    private Long id;
    private String name;

    @QueryProjection
    public CitySearchDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
