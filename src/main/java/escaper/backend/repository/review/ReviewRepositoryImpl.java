package escaper.backend.repository.review;


import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static escaper.backend.entity.review.QReview.review;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    @Override
    public Double calculateThemeRatingAverage(Long themeId) {
        return queryFactory.select(review.rating.avg())
                .from(review)
                .where(review.theme.id.eq(themeId))
                .fetchOne();
    }
}
