package escaper.backend.repository.theme;

import escaper.backend.entity.theme.ThemeSearchDto;

import java.util.List;

public interface ThemeRepositoryCustom {

    List<ThemeSearchDto> searchTheme(String condition);

}
