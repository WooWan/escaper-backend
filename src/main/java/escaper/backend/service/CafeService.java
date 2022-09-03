package escaper.backend.service;

import escaper.backend.entity.cafe.CafeSearchDto;
import escaper.backend.repository.cafe.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CafeService {

    private final CafeRepository cafeRepository;

    public List<String> searchCities() {
        return cafeRepository.searchCities();
    }

    public List<String> searchArea(String city) {
        return cafeRepository.searchArea(city);
    }

    public List<CafeSearchDto> searchCafe(String area){
        return cafeRepository.searchCafe(area);
    }
}
