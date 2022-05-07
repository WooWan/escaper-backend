package escaper.backend.controller;

import escaper.backend.repository.cafe.CafeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@RestController
public class CafeController {

    private final CafeRepository cafeRepository;

    @GetMapping("/api/address")
    public List<String> getCity() {
        return cafeRepository.getCity();
    }

    @GetMapping("/api/area")
    public List<String> getArea(@RequestParam(required = false) String city) {
        List<String> areaByCity = cafeRepository.getAreaByCity(city);
        log.info("area  : {}", areaByCity);
        return areaByCity;
    }
}
