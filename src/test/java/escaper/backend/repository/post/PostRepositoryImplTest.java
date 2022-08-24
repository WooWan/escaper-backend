package escaper.backend.repository.post;

import escaper.backend.config.QuerydslTestConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@DataJpaTest
@Transactional
@Import(QuerydslTestConfiguration.class)
class PostRepositoryImplTest {

    @Autowired
    EntityManager em;



}