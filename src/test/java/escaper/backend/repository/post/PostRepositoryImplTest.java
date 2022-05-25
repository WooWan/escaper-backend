package escaper.backend.repository.post;

import escaper.backend.config.QuerydslTestConfiguration;
import escaper.backend.entity.Post;
import escaper.backend.entity.PostResponseDto;
import escaper.backend.entity.User;
import escaper.backend.entity.theme.Theme;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
@Transactional
@Import(QuerydslTestConfiguration.class)
class PostRepositoryImplTest {

    @Autowired
    private PostRepositoryImpl postRepository;
    @Autowired
    EntityManager em;

    @Test
    @DisplayName("모든 post가 페치된다")
    public void 페치_post() {
        //given
        Theme theme1 = new Theme("theme1");
        Theme theme2 = new Theme("theme2");
        em.persist(theme1);
        em.persist(theme2);
        User user1 = new User("user1");
        em.persist(user1);
        Post post1 = new Post("post1", "content1", user1, theme1);
        Post post2 = new Post("post2", "content2", user1, theme1);
        Post post3 = new Post("post3", "content3", user1, theme2);
        em.persist(post1);
        em.persist(post2);
        em.persist(post3);
        //when
        List<PostResponseDto> results = postRepository.findPagePost();

        //then
        assertThat(results.size()).isEqualTo(3);
    }

}