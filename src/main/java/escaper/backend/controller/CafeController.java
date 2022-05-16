package escaper.backend.controller;

import escaper.backend.entity.AddressDto;
import escaper.backend.entity.Cafe;
import escaper.backend.repository.cafe.CafeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Getter
@RequiredArgsConstructor
@RestController
public class CafeController {

    private final CafeRepository cafeRepository;

    @GetMapping("/api/city")
    public List<String> getCity() {
        return cafeRepository.getCity();
    }

    @GetMapping("/api/area")
    public List<String> getArea(@RequestParam(required = false) String city) {
        return cafeRepository.getAreaByCity(city);
    }

    @GetMapping("/api/address")
    public List<AddressDto> getAddress() {
        List<Cafe> cafeList = cafeRepository.findAll();
        return cafeList.stream()
                .map(AddressDto::new)
                .collect(Collectors.toList());
    }
}
