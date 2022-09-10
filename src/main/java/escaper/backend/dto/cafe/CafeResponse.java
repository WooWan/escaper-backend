package escaper.backend.dto.cafe;

import escaper.backend.entity.cafe.Address;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CafeResponse {
    private Long id;
    private String name;
    private Address address;

    @Builder
    public CafeResponse(Long id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
