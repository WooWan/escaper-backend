package escaper.backend.controller;


import escaper.backend.service.ThemeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@Getter
@RequiredArgsConstructor
@RestController
public class ThemeController {

    private final ThemeService themeService;
}
