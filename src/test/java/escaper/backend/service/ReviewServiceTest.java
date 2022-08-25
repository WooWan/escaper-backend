package escaper.backend.service;

import escaper.backend.config.ServiceTestConfig;
import escaper.backend.dto.review.CreateRating;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.theme.Theme;
import escaper.backend.repository.cafe.CafeRepository;
import escaper.backend.repository.review.ReviewRepository;
import escaper.backend.repository.theme.ThemeRepository;
import escaper.backend.service.review.ReviewService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
class ReviewServiceTest extends ServiceTestConfig {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private CafeRepository cafeRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ThemeRepository themeRepository;
    private Theme theme1;

    @BeforeEach
    public void createTheme() {
        Cafe cafe = new Cafe();
        cafeRepository.save(cafe);
        this.theme1 = themeRepository.save(Theme.builder()
                .cafe(cafe)
                .name("name")
                .rating(0.0)
                .genre("스릴러")
                .timeLimitation(60)
                .appropriatedPeople(3)
                .cost(22000)
                .imageURL("www.com")
                .build());
    }

    @AfterEach
    public void deleteAll() {
        themeRepository.deleteAll();
        cafeRepository.deleteAll();
    }

    @Test
    @DisplayName("유저가 평점을 등록한다")
    void rateTheme() {
        Long themeId = theme1.getId();

        Long memberId = member1.getUserSeq();

        CreateRating createRating = new CreateRating(3.0);
        reviewService.rateTheme(themeId, memberId, createRating);

        assertThat(theme1.getRating()).isEqualTo(3.0);

        CreateRating createRating2 = new CreateRating(4.0);
        reviewService.rateTheme(themeId, memberId, createRating2);

        assertThat(theme1.getRating()).isEqualTo(3.5);
    }
}