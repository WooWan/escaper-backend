package escaper.backend.controller;

import escaper.backend.entity.cafe.CafeSearchDto;
import escaper.backend.entity.theme.ThemeSearchDto;
import escaper.backend.service.CafeService;
import escaper.backend.service.ThemeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SearchController {

    private final CafeService cafeService;
    private final ThemeService themeService;

    @GetMapping("/api/cities/search")
    public List<String> getCity() {
        return cafeService.searchCities();
    }

    @GetMapping("/api/areas/search")
    public List<String> searchArea(@RequestParam(required = false) String city) {
        return cafeService.searchArea(city);
    }

    @GetMapping("/api/cafes/search")
    public List<CafeSearchDto> searchCafe(@RequestParam(required = false, defaultValue = "") String area) {
        log.info("cafe search");
        return cafeService.searchCafe(area);
    }

    @GetMapping("/api/themes/search")
    public List<ThemeSearchDto> searchThemes(@RequestParam(required = false, defaultValue = "") String cafe) {
        log.info("cafe search");
        return themeService.searchCafe(cafe);
    }
}
