package escaper.backend.controller;

import escaper.backend.entity.cafe.*;
import escaper.backend.repository.cafe.CafeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Getter
@RequiredArgsConstructor
@RestController
public class CafeController {

    private final CafeRepository cafeRepository;

    @GetMapping("/api/cities")
    public List<String> getCity() {
        return cafeRepository.searchCities();
    }

    @GetMapping("/api/areas")
    public List<String> searchArea(@RequestParam(required = false) String city) {
        return cafeRepository.searchArea(city);
    }

    @GetMapping("/api/cafes")
    public List<CafeSearchDto> searchCafe(@RequestParam(required = false) String area) {
        return cafeRepository.searchCafe(area);
    }

}
