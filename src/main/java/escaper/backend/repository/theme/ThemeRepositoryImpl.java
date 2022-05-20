package escaper.backend.repository.theme;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;

import escaper.backend.entity.theme.QThemeSearchDto;
import escaper.backend.entity.theme.ThemeSearchCondition;
import escaper.backend.entity.theme.ThemeSearchDto;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static escaper.backend.entity.QCafe.cafe;
import static escaper.backend.entity.theme.QTheme.theme;
import static org.springframework.util.StringUtils.hasText;

public class ThemeRepositoryImpl implements ThemeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public ThemeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<ThemeSearchDto> themeSearch(ThemeSearchCondition condition) {
        return queryFactory.select(new QThemeSearchDto(
                        theme.id,
                        theme.name))
                .from(theme)
                .where(cityNameEq(condition.getCityName()), areaNameEq(condition.getAreaName()), cafeNameEq(condition.getCafeName()))
                .fetch();
    }

    private Predicate cafeNameEq(String cafeName) {
        return hasText(cafeName) ? cafe.name.eq(cafeName) : null;
    }

    private Predicate areaNameEq(String areaName) {
        return hasText(areaName) ? cafe.name.eq(areaName) : null;
    }

    private Predicate cityNameEq(String cityName) {
        return hasText(cityName) ? cafe.name.eq(cityName) : null;
    }

}
