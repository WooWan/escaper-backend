package escaper.backend.repository.cafe;

import escaper.backend.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe, Integer>, CafeRepositoryCustom {
}
