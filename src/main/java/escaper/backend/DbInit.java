package escaper.backend;

import escaper.backend.entity.Post;
import escaper.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

import static escaper.backend.entity.Post.createPost;

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
            Post post1 = createPost("dbinit", "test");
            postRepository.save(post1);

            Post post2 = createPost("dbinit2", "test2");
            postRepository.save(post2);

            Post post3 = createPost("dbinit3", "test3");
            postRepository.save(post3);
        }
    }
}
