package escaper.backend.controller;

import escaper.backend.repository.cafe.CafeRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CafeControllerTest {

    @Mock
    private CafeRepository cafeRepository;
    @InjectMocks
    private CafeController cafeController;

    @Test
    @DisplayName("모든 카페 이름을 리턴한다")
    public void getCafeName() {
        //given
//        cafeController.getCity();
        //when
        //then
//        verify(cafeRepository).getCity();
    }

}