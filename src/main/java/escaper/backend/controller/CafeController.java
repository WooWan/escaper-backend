package escaper.backend.controller;

import escaper.backend.dto.cafe.CafeDto;
import escaper.backend.entity.cafe.*;
import escaper.backend.repository.cafe.CafeRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/api/cafes/search")
    public List<CafeSearchDto> searchCafe(@RequestParam(required = false) String area) {
        return cafeRepository.searchCafe(area);
    }

    @GetMapping("/api/cafes")
    public List<CafeDto> getCafes() {
        return cafeRepository.findAll().stream()
                .map(CafeDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/api/cafe/{id}")
    public CafeDto getCafeById(@PathVariable Long id) {
        Cafe findCafe = cafeRepository.findCafeById(id);
        return new CafeDto(findCafe);
    }

}
