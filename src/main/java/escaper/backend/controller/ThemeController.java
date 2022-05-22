package escaper.backend.controller;

import escaper.backend.entity.theme.ThemeSearchDto;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.service.ThemeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Getter
@RequiredArgsConstructor
@RestController
public class ThemeController {

    private final ThemeService themeService;
    private final ThemeRepository themeRepository;

    @GetMapping("api/themes")
    public List<ThemeSearchDto> searchTheme(@RequestParam(required = false) String cafe) {
        return themeRepository.searchTheme(cafe);
    }
}
