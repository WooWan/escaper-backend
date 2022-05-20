package escaper.backend.repository.theme;

import escaper.backend.entity.theme.ThemeSearchCondition;
import escaper.backend.entity.theme.ThemeSearchDto;

import java.util.List;

public interface ThemeRepositoryCustom {

    List<ThemeSearchDto> themeSearch(ThemeSearchCondition condition);

}
