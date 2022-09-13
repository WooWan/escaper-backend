package escaper.backend.dto.cafe;

import escaper.backend.dto.theme.ThemeResponse;
import escaper.backend.entity.cafe.Address;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.theme.Theme;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CafeDto {

    private Long id;
    private String name;
    private Address address;
    private String phoneNumber;
    private List<ThemeResponse> themes;

    @Builder
    public CafeDto(Long id, String name, Address address, String phoneNumber, List<Theme> themeList) {
       this.id = id;
        this.name= name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.themes = themeList.stream()
                .map(ThemeResponse::new)
                .collect(Collectors.toList());
    }

    public CafeDto(Cafe cafe) {
        this.id = cafe.getId();
        this.name= cafe.getName();
        this.address = cafe.getAddress();
        this.phoneNumber = cafe.getPhoneNumber();
        this.themes = cafe.getThemeList().stream()
                .map(ThemeResponse::new)
                .collect(Collectors.toList());
    }
}
