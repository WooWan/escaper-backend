package escaper.backend;

import escaper.backend.entity.*;
import escaper.backend.entity.cafe.Address;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.theme.Theme;
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
        initService.dbInit2();
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
//
//            Theme theme1 = new Theme("숨겨진 별장의 비밀");
//            Theme theme2 = new Theme("우주로 나간 아이");
//            Theme theme3 = new Theme("몬스터");
//            em.persist(theme1);
//            em.persist(theme2);
//            em.persist(theme3);
//            Post post1 = createPost("post1", "test", user1, theme1);
//            postRepository.save(post1);
//
//            Post post2 = createPost("post2", "test2", user1,theme2);
//            postRepository.save(post2);
//
//
//            Post post3 = createPost("post3", "test3", user2, theme3);
//            postRepository.save(post3);
//            Post post4 = createPost("post4", "test4", user2, theme2);
//            postRepository.save(post4);
        }

        private Post createPost(String title, String content, User user, Theme theme) {
            return new Post(title, content, user, theme);
        }

        public void dbInit2() {
            Address address = new Address("서울", "홍대");
            Address address2 = new Address("경기도", "수원");
            Address address3 = new Address("서울", "강남");
            Cafe cafe = new Cafe("키이스케이프", address);
            Cafe cafe2 = new Cafe("소우주", address2);
            Cafe cafe3 = new Cafe("코드케이", address3);

            em.persist(cafe);
            em.persist(cafe2);
            em.persist(cafe3);
            Theme theme = new Theme("삐릿-뽀", cafe);
            Theme theme2 = new Theme("홀리데이", cafe);
            Theme theme3 = new Theme("고백", cafe);

            Theme theme4 = new Theme("풀문", cafe2);
            Theme theme5 = new Theme("도고", cafe2);

            Theme theme6 = new Theme("꼬레 아우라", cafe3);

            em.persist(theme);
            em.persist(theme2);
            em.persist(theme3);
            em.persist(theme4);
            em.persist(theme5);
            em.persist(theme6);
            Theme theme7 = new Theme("숨겨진 별장의 비밀", cafe);
            Theme theme8 = new Theme("우주로 나간 아이", cafe);
            Theme theme9 = new Theme("몬스터",cafe);
            em.persist(theme7);
            em.persist(theme8);
            em.persist(theme9);
        }
    }
}
