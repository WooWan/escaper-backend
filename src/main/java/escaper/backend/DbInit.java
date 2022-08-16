package escaper.backend;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.cafe.Address;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.user.User;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.theme.Theme;
import escaper.backend.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static escaper.backend.entity.post.Post.createPost;


@Component
@RequiredArgsConstructor
@Slf4j
public class DbInit {

    private final InitService initService;
    private final PostService postService;

    @PostConstruct
    private void init() {
//        initService.dbInit();
        initService.dbInit2();
    }

    @RequiredArgsConstructor
    @Component
    @Transactional
    static class InitService {

        private final EntityManager em;
        private final PostService postService;

        public void dbInit() {
            User user1 = new User("user1");
            User user2 = new User("user2");
            em.persist(user1);
            em.persist(user2);
            Cafe cafe = new Cafe("키이스케이프", new Address("서울", "성수"));
            em.persist(cafe);

            Theme theme1 = new Theme("별이 빛나는 밤", cafe, "액션");
            Theme theme2 = new Theme("별이 빛나는 밤", cafe, "스릴러");
            Theme theme3 = new Theme("별이 빛나는 밤", cafe, "스릴러");
            em.persist(theme1);
            em.persist(theme2);
            em.persist(theme3);


            Post post1 = createPost("같이 홍대 방탈출 하러 갈 2명 구해요!!", "test", user1, LocalDate.of(2022,6,3));
            post1.addTheme(theme1);
            post1.addTheme(theme2);

            Post post2 = createPost("post2", "test2", user1, LocalDate.of(2022, 6, 3));
            Post post3 = createPost("post3", "test3", user2,LocalDate.of(2022,6,3));
            Post post4 = createPost("post4", "test4", user2, LocalDate.of(2022,6,3));
            Post post5 = createPost("post2", "test2", user1,LocalDate.of(2022,6,3));
            Post post6 = createPost("post3", "test3", user2,LocalDate.of(2022,6,3));
            Post post7 = createPost("post4", "test4", user2, LocalDate.of(2022, 6, 3));
            Post post8 = createPost("post2", "test2", user1,LocalDate.of(2022,6,3));
            Post post9 = createPost("post3", "test3", user2,LocalDate.of(2022,6,3));
            Post post10 = createPost("post4", "test4", user2, LocalDate.of(2022,6,3));
            Post post11 = createPost("post2", "test2", user1,LocalDate.of(2022,6,3));

//            em.persist(post1);
//            em.persist(post2);
//            em.persist(post3);
//            em.persist(post4);
//            em.persist(post5);
//            em.persist(post6);
//            em.persist(post7);
//            em.persist(post8);
//            em.persist(post9);
//            em.persist(post10);
//            em.persist(post11);
//
//            em.flush();
//            em.clear();

            CreatePostRequest request = new CreatePostRequest("title1", "content", 1, LocalDate.of(2022, 2, 2), List.of(theme1.getId(), theme2.getId()));
            postService.savePost(request);






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
            Theme theme = new Theme("삐릿-뽀", cafe, "스릴러");
            Theme theme2 = new Theme("홀리데이", cafe, "스릴러");
            Theme theme3 = new Theme("고백", cafe, "스릴러");

            Theme theme4 = new Theme("풀문", cafe2, "스릴러");
            Theme theme5 = new Theme("도고", cafe2, "스릴러");

            Theme theme6 = new Theme("꼬레 아우라", cafe3, "스릴러");
            Theme theme7 = new Theme("꼬레 아우라", cafe3, "스릴러");
            Theme theme8 = new Theme("꼬레 아우라", cafe3, "로맨스");

            em.persist(theme);
            em.persist(theme2);
            em.persist(theme3);
            em.persist(theme4);
            em.persist(theme5);
            em.persist(theme6);
            em.persist(theme7);
            em.persist(theme8);
//            Theme theme7 = new Theme("숨겨진 별장의 비밀", cafe);
//            Theme theme8 = new Theme("우주로 나간 아이", cafe);
//            Theme theme9 = new Theme("몬스터",cafe);
//            em.persist(theme7);
//            em.persist(theme8);
//            em.persist(theme9);
        }
    }
}
