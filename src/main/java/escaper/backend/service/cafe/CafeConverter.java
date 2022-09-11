package escaper.backend.service.cafe;

import escaper.backend.dto.cafe.CafeResponse;
import escaper.backend.entity.cafe.Cafe;

public class CafeConverter {

    public static CafeResponse toCafeResponse(Cafe cafe){
        return CafeResponse.builder()
                .id(cafe.getId())
                .name(cafe.getName())
                .address(cafe.getAddress())
                .build();
    }

}
