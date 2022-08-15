package escaper.backend.repository.cafe;

import escaper.backend.entity.cafe.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CafeRepository extends JpaRepository<Cafe, Long>, CafeRepositoryCustom {

    @Query("SELECT DISTINCT c.address.city FROM Cafe c")
    List<String> searchCities();

}
