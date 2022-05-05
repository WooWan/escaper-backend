package escaper.backend;

import escaper.backend.entity.Post;
import escaper.backend.entity.Theme;
import escaper.backend.entity.User;
import escaper.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit {

    private final InitService initService;

    @PostConstruct
    private void init() {
        initService.dbInit();
    }

    @RequiredArgsConstructor
    @Component
    @Transactional
    static class InitService {

        private final EntityManager em;
        private final PostRepository postRepository;

        public void dbInit() {
            User user1 = new User("user1");
            User user2 = new User("user2");
            em.persist(user1);
            em.persist(user2);
            Theme theme1 = new Theme("숨겨진 별장의 비밀");
            Theme theme2 = new Theme("우주로 나간 아이");
            Theme theme3 = new Theme("몬스터");
            em.persist(theme1);
            em.persist(theme2);
            em.persist(theme3);
            Post post1 = createPost("post1", "test", user1, theme1);
            postRepository.save(post1);

            Post post2 = createPost("post2", "test2", user1,theme2);
            postRepository.save(post2);


            Post post3 = createPost("post3", "test3", user2, theme3);
            postRepository.save(post3);
            Post post4 = createPost("post4", "test4", user2, theme2);
            postRepository.save(post4);
        }

        private Post createPost(String title, String content, User user, Theme theme) {
            return new Post(title, content, user, theme);
        }
    }
}
