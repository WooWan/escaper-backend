package escaper.backend.service.theme;

import escaper.backend.dto.theme.ThemeTypes;
import escaper.backend.entity.theme.ThemeSearchDto;
import escaper.backend.repository.theme.ThemeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Transactional
@Service
public class ThemeService {

    private final ThemeRepository themeRepository;

    public List<ThemeTypes> getThemeTypes() {
        List<ThemeTypes> result = themeRepository.findThemeTypes();
        Set<String> nameSet = new HashSet<>();
        return result.stream()
                .filter(theme -> nameSet.add(theme.getGenre()))
                .collect(Collectors.toList());
    }

    public List<ThemeSearchDto> searchCafe(String cafe) {
        return themeRepository.searchTheme(cafe);
    }
}
