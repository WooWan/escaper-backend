package escaper.backend.entity;

import lombok.Data;

@Data
public class AddressDto {

    public AddressDto(Cafe cafe) {
        this.city = cafe.getAddress().getCity();
        this.area = cafe.getAddress().getArea();
    }
    private String city;
    private String area;
}
