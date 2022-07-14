package escaper.backend.repository.theme;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import escaper.backend.entity.theme.QThemeSearchDto;
import escaper.backend.entity.theme.Theme;
import escaper.backend.entity.theme.ThemeSearchDto;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static escaper.backend.entity.cafe.QCafe.cafe;
import static escaper.backend.entity.theme.QTheme.theme;
import static org.springframework.util.StringUtils.hasText;

@RequiredArgsConstructor
public class ThemeRepositoryImpl implements ThemeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ThemeSearchDto> searchTheme(String condition) {
        return queryFactory.select(new QThemeSearchDto(
                        theme.id,
                        theme.name))
                .from(theme)
                .where(themeNameEq(condition))
                .fetch();
    }

    @Override
    public List<Theme> findPopularTheme() {
        return queryFactory.selectFrom(theme)
                .orderBy(theme.rate.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<Theme> findThemeByGenre(String genre) {
        return queryFactory.selectFrom(theme)
                .where(genreNameEq(genre))
                .limit(10)
                .fetch();
    }

    private Predicate genreNameEq(String genre) {
        return hasText(genre) ? theme.genre.eq(genre) : null;
    }

    private Predicate themeNameEq(String condition) {
        return hasText(condition) ? cafe.name.eq(condition) : null;
    }


}
