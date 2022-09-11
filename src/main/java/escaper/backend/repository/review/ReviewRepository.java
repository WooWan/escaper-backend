package escaper.backend.repository.review;

import escaper.backend.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {

    @Query("select r from Review r join fetch r.member where r.theme.id =:themeId and r.content is not null")
    List<Review> findReviewByThemeId(@Param("themeId") Long themeId);

    @Query("select r from Review r where r.rating >= 0.5 and r.theme.id =:themeId")
    List<Review> getRatingOfTheme(@Param("themeId") Long themeId);

    @Query("select r from Review r" +
            " join r.theme t " +
            " join r.member m" +
            " where r.theme.id=:themeId and r.member.userSeq=:memberId")
    Optional<Review> findReviewByUser(Long memberId, Long themeId);
}
