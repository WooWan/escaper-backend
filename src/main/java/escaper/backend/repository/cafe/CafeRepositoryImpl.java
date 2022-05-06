package escaper.backend.repository.cafe;

import com.querydsl.jpa.impl.JPAQueryFactory;
import javax.persistence.EntityManager;
import java.util.List;


import static escaper.backend.entity.QCafe.cafe;

public class CafeRepositoryImpl implements CafeRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public CafeRepositoryImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<String> getAddress() {
        return queryFactory.select(cafe.address.city).distinct()
                .from(cafe)
                .fetch();
    }
}
