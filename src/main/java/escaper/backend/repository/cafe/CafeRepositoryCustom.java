package escaper.backend.repository.cafe;

import escaper.backend.entity.cafe.*;

import java.util.List;

public interface CafeRepositoryCustom {

    List<String> searchArea(String condition);

    List<CafeSearchDto> searchCafe(String condition);

}
