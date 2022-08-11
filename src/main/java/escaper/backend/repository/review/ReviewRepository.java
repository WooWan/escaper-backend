package escaper.backend.repository.review;

import escaper.backend.entity.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(value = "select r from Review r where r.theme.id= :id")
    List<Review> findByThemeId(@Param("id") Long themeId);
}
