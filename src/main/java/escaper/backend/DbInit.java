package escaper.backend;

import escaper.backend.entity.Post;
import escaper.backend.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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
    static class InitService {

        private final PostRepository postRepository;

        public void dbInit() {
            log.info("DB Init");
            Post newPost = new Post();
            newPost.createPost("dbinit", "test");
            postRepository.save(newPost);
        }
    }
}
