package escaper.backend;

import escaper.backend.entity.Post;
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
            Post post1 = createPost("dbinit", "test", user1);
            postRepository.save(post1);

            Post post2 = createPost("dbinit2", "test2", user1);
            postRepository.save(post2);


            Post post3 = createPost("dbinit3", "test3", user2);
            postRepository.save(post3);
        }

        private Post createPost(String title, String content, User user) {
            return new Post(title, content, user);
        }
    }
}
