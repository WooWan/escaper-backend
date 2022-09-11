package escaper.backend.repository.review;

import escaper.backend.entity.review.Review;
import escaper.backend.entity.theme.Theme;
import escaper.backend.repository.theme.ThemeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class ReviewRepositoryImplTest {

    @Autowired
    EntityManager em;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ThemeRepository themeRepository;

    @Test
    @DisplayName("평점 평균 계산")
    public void calculateRatingAvg() {
        //given
        Theme theme = new Theme("theme");
        Long id = themeRepository.save(theme).getId();

        Review review = new Review(3.0, "content");
        review.addTheme(theme);

        reviewRepository.save(review);
        Double rating = reviewRepository.calculateThemeRatingAverage(id);
        assertThat(rating).isEqualTo(3.0);

        //2번째 평점을 등록해도 정상 작동
        Review review2 = new Review(4.0, "content2");
        review2.addTheme(theme);

        reviewRepository.save(review2);
        Double rating2 = reviewRepository.calculateThemeRatingAverage(id);
        assertThat(rating2).isEqualTo(3.5);
    }

}