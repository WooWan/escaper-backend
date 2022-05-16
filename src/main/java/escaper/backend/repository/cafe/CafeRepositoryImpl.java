package escaper.backend.repository.cafe;

import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.EntityManager;
import java.util.List;
import static escaper.backend.entity.QCafe.cafe;
import static org.springframework.util.StringUtils.hasText;

@Slf4j
public class CafeRepositoryImpl implements CafeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CafeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<String> getCity() {
        return queryFactory.select(cafe.address.city).distinct()
                .from(cafe)
                .fetch();
    }

    @Override
    public List<String> getAreaByCity(String cityCond) {
        log.info("city condition : {}", cityCond);
        return queryFactory.select(cafe.address.area).distinct()
                .from(cafe)
                .where(cityEq(cityCond))
                .fetch();
    }

    private Predicate cityEq(String city) {
        return hasText(city) ? cafe.address.city.eq(city) : null;
    }


}
