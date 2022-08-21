package escaper.backend.repository.review;

import escaper.backend.entity.review.Review;
import escaper.backend.entity.theme.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query("select r from Review r")
    List<Review> findByThemeWithCon(@Param("id") Long themeId);

    @Query("select r from Review r" +
            " join r.theme t " +
            " join r.member m" +
            " where r.theme.id=:themeId and r.member.userSeq=:memberId")
    Optional<Review> findReviewByUser(Long memberId, Long themeId);
}
