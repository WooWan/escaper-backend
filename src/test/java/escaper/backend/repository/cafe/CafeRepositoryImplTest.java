package escaper.backend.repository.cafe;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.mockito.Mockito.when;

@DataJpaTest
class CafeRepositoryImplTest {

    @Autowired
    private CafeRepositoryImpl underTest;


}