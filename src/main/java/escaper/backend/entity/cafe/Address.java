package escaper.backend.entity.cafe;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@NoArgsConstructor
@Embeddable @Getter
public class Address {

    private String city;
    private String area;
    private String streets;
    private String detail;

    public Address(String city, String area, String streets) {
        this.city = city;
        this.area = area;
        this.streets = streets;
    }


    public Address(String city, String area, String streets, String detail) {
        this.city = city;
        this.area = area;
        this.streets = streets;
        this.detail = detail;
    }
}
