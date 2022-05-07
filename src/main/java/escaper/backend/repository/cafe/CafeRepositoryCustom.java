package escaper.backend.repository.cafe;

import java.util.List;

public interface CafeRepositoryCustom {

    List<String> getCity();
    List<String> getAreaByCity(String city);
}
