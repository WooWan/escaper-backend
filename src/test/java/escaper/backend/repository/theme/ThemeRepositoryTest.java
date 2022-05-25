package escaper.backend.repository.theme;

import escaper.backend.config.QuerydslTestConfiguration;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.theme.Theme;
import escaper.backend.entity.theme.ThemeSearchCondition;
import escaper.backend.entity.theme.ThemeSearchDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@Transactional
@Import(QuerydslTestConfiguration.class)
class ThemeRepositoryTest {
    @Autowired
    private ThemeRepository themeRepository;
    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("조건에 맞는 항목만 서치되어야 한다")
    public void 테마서치_조건_테스트() {
        //given
        Cafe cafe = new Cafe("cafeA");
        entityManager.persist(cafe);

        Theme theme = new Theme("theme1", cafe);
        entityManager.persist(theme);
        //when
        String condition = "cafeA";
        List<ThemeSearchDto> results = themeRepository.searchTheme(condition);
        //then
        assertThat(results).extracting("themeName").contains("theme1");
    }
}