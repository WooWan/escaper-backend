package escaper.backend.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
@NoArgsConstructor
@Embeddable
public class Address {

    private String city;
    private String area;

    public Address(String city, String area) {
        this.city = city;
        this.area = area;
    }
}
