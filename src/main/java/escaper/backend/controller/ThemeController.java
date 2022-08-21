package escaper.backend.controller;

import escaper.backend.dto.theme.ThemeDetailDto;
import escaper.backend.entity.theme.Theme;
import escaper.backend.dto.theme.ThemeDto;
import escaper.backend.dto.theme.ThemeTypes;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.service.ThemeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.*;

@Getter
@RequiredArgsConstructor
@RestController
public class ThemeController {

    private final ThemeService themeService;
    private final ThemeRepository themeRepository;


    @GetMapping("/api/themes")
    public List<ThemeDto> fetchThemes() {
        List<Theme> results = themeRepository.findAll();
        return results.stream()
                .map(ThemeDto::new)
                .collect(toList());
    }

    @GetMapping("/api/theme/{id}")
    public ThemeDetailDto fetchThemeById(@PathVariable Long id) {
        return themeRepository.findThemeCafeById(id);
    }

//    @GetMapping("/api/themes")
//    public List<ThemeSearchDto> searchTheme(@RequestParam(required = false) String cafe) {
//        return themeRepository.searchTheme(cafe);
//    }

    @GetMapping("/api/themes/popular")
    public List<ThemeDto> findPopularTheme() {
        List<Theme> results = themeRepository.findPopularTheme();
        return results.stream()
                .map(ThemeDto::new)
                .collect(toList());
    }

    @GetMapping("/api/themes/{genre}")
    public List<ThemeDto> findThemeByGenre(@PathVariable String genre) {
        List<Theme> results = themeRepository.findThemeByGenre(genre);
        return results.stream()
                .map(ThemeDto::new)
                .collect(toList());
    }

    @GetMapping("/api/themes/type")
    public List<ThemeTypes> themeTypes() {
        return themeService.getThemeTypes();
    }

}
