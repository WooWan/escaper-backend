package escaper.backend.repository.theme;

import escaper.backend.entity.theme.Theme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ThemeRepository extends JpaRepository<Theme, Long>, ThemeRepositoryCustom {

}
