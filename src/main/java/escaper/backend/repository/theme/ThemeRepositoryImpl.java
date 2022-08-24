package escaper.backend.repository.theme;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.dto.theme.QThemeDetailDto;
import escaper.backend.dto.theme.QThemeTypes;
import escaper.backend.dto.theme.ThemeDetailDto;
import escaper.backend.dto.theme.ThemeTypes;
import escaper.backend.entity.theme.*;
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
    public Theme findThemeById(Long id) {
        return queryFactory.selectFrom(theme)
                .where(theme.id.eq(id))
                .fetchOne();
    }

    @Override
    public List<Theme> findPopularTheme() {
        return queryFactory.selectFrom(theme)
                .orderBy(theme.rating.desc())
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

    @Override
    public List<ThemeTypes> findThemeTypes() {
        return queryFactory.select(new QThemeTypes(theme.id, theme.genre))
                .from(theme)
                .fetch();
    }

    @Override
    public ThemeDetailDto findThemeCafeById(Long id) {
        return queryFactory.select(new QThemeDetailDto(theme.id, theme.name, theme.genre, theme.description, theme.timeLimitation, theme.appropriatedPeople, theme.rating, theme.cost, theme.imageURL, cafe.id,cafe.phoneNumber, cafe.name))
                .from(theme)
                .leftJoin(theme.cafe, cafe)
                .where(theme.id.eq(id))
                .fetchOne();
    }

    private Predicate genreNameEq(String genre) {
        return hasText(genre) ? theme.genre.eq(genre) : null;
    }

    private Predicate themeNameEq(String condition) {
        return hasText(condition) ? cafe.name.eq(condition) : null;
    }


}
