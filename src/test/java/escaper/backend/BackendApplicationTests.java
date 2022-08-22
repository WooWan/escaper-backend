package escaper.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = ConfigDataApplicationContextInitializer.class)
class BackendApplicationTests {

	@Test
	void contextLoads() {
	}

}
