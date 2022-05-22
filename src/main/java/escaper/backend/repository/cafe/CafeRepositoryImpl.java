package escaper.backend.repository.cafe;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import escaper.backend.entity.cafe.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;


import static escaper.backend.entity.cafe.QCafe.cafe;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
@RequiredArgsConstructor
public class CafeRepositoryImpl implements CafeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<String> searchArea(String condition) {
        return queryFactory.select(cafe.address.area)
                .distinct()
                .from(cafe)
                .where(cityEq(condition))
                .fetch();
    }

    @Override
    public List<CafeSearchDto> searchCafe(String condition) {
        return queryFactory.select(new QCafeSearchDto(cafe.id, cafe.name))
                .from(cafe)
                .where(areaEq(condition))
                .fetch();
    }

    private Predicate areaEq(String area) {
        return hasText(area) ? cafe.address.area.eq(area) : null;
    }

    private Predicate cityEq(String city) {
        return hasText(city) ? cafe.address.city.eq(city) : null;
    }


}
