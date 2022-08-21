package escaper.backend.repository.theme;

import escaper.backend.dto.theme.ThemeDetailDto;
import escaper.backend.entity.theme.Theme;
import escaper.backend.entity.theme.ThemeSearchDto;
import escaper.backend.dto.theme.ThemeTypes;

import java.util.List;

public interface ThemeRepositoryCustom {

    List<ThemeSearchDto> searchTheme(String condition);

    Theme findThemeById(Long id);
    List<Theme> findPopularTheme();

    List<Theme> findThemeByGenre(String genre);

    List<ThemeTypes> findThemeTypes();

   ThemeDetailDto findThemeCafeById(Long id);

}
