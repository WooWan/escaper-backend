package escaper.backend.service.cafe;

import escaper.backend.dto.cafe.CafeDto;
import escaper.backend.dto.cafe.CafeResponse;
import escaper.backend.dto.theme.ThemeResponse;
import escaper.backend.entity.cafe.Cafe;

import java.util.stream.Collectors;

public class CafeConverter {

    public static CafeResponse toCafeResponse(Cafe cafe){
        return CafeResponse.builder()
                .name(cafe.getName())
                .address(cafe.getAddress())
                .build();
    }

}
