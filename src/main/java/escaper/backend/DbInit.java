package escaper.backend;

import escaper.backend.dto.post.CreatePostRequest;
import escaper.backend.entity.cafe.Address;
import escaper.backend.entity.cafe.Cafe;
import escaper.backend.entity.post.Post;
import escaper.backend.entity.theme.Theme;
import escaper.backend.entity.member.Member;
import escaper.backend.oauth.entity.ProviderType;
import escaper.backend.oauth.entity.RoleType;
import escaper.backend.service.post.PostService;
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
        initService.dbInit();
        initService.dbInit2();
    }

    @RequiredArgsConstructor
    @Component
    @Transactional
    static class InitService {

        private final EntityManager em;
        private final PostService postService;

        public void dbInit() {

            Member member1 = new Member("user1", "username", "1234", ProviderType.GOOGLE, RoleType.USER);
            Member member2 = new Member("user1", "username", "1234", ProviderType.GOOGLE, RoleType.USER);
            em.persist(member1);
//            em.persist(user2);
            Cafe cafe = new Cafe("키이스케이프", "010-1234-1234", new Address("서울", "성수"));
            em.persist(cafe);

            String description = " Production grade React applications that scale. The world's leading\n" +
                    "          companies use Next.js by Vercel to build static and dynamic websites\n" +
                    "          and web applications Welcome to the Next.js documentation! If you're\n" +
                    "          new to Next.js, we recommend starting with the learn course. The\n" +
                    "          interactive course with quizzes will guide you through everything you\n" +
                    "          need to know to use Next.js. If you have questions about anything\n" +
                    "          related to Next.js, you're always welcome to ask our community on\n" +
                    "          GitHub Discussions.";

            Theme theme1 = Theme.builder()
                    .cafe(cafe)
                    .name("꼬레아우라")
                    .description(description)
                    .rating(0.0)
                    .genre("스릴러")
                    .timeLimitation(60)
                    .appropriatedPeople(3)
                    .cost(22000)
                    .imageURL("www.com")
                    .build();
            Theme theme2 = Theme.builder()
                    .cafe(cafe)
                    .name("꼬레아우라")
                    .description(description)
                    .rating(0.0)
                    .genre("스릴러")
                    .timeLimitation(60)
                    .appropriatedPeople(3)
                    .cost(22000)
                    .imageURL("www.com")
                    .build();
            Theme theme3 = Theme.builder()
                    .cafe(cafe)
                    .name("꼬레아우라")
                    .description(description)
                    .rating(0.0)
                    .genre("스릴러")
                    .timeLimitation(60)
                    .appropriatedPeople(3)
                    .cost(22000)
                    .imageURL("www.com")
                    .build();
            em.persist(theme1);
            em.persist(theme2);
            em.persist(theme3);


            Post post1 = createPost("같이 홍대 방탈출 하러 갈 2명 구해요!!", "test", member1, LocalDate.of(2022,6,3));
            post1.addTheme(theme1);


            em.persist(post1);

            em.flush();
            em.clear();
        }

        public void dbInit2() {
            Theme theme = createTheme();
            Theme theme2 = createTheme();
            Theme theme3 = createTheme();

            Theme theme4 = createTheme();
            Theme theme5 = createTheme();

            Theme theme6 = createTheme();
            Theme theme7 = createTheme();
            Theme theme8 = createTheme();

            em.persist(theme);
            em.persist(theme2);
            em.persist(theme3);
            em.persist(theme4);
            em.persist(theme5);
            em.persist(theme6);
            em.persist(theme7);
            em.persist(theme8);
        }
        public Theme createTheme() {
            Cafe cafe = new Cafe("키이스케이프", "010-1234-1234", new Address("서울특별시", "강서구"));
            em.persist(cafe);
            String description = " Production grade React applications that scale. The world's leading\n" +
                    "          companies use Next.js by Vercel to build static and dynamic websites\n" +
                    "          and web applications Welcome to the Next.js documentation! If you're\n" +
                    "          new to Next.js, we recommend starting with the learn course. The\n" +
                    "          interactive course with quizzes will guide you through everything you\n" +
                    "          need to know to use Next.js. If you have questions about anything\n" +
                    "          related to Next.js, you're always welcome to ask our community on\n" +
                    "          GitHub Discussions.";
            return Theme.builder()
                    .cafe(cafe)
                    .name("꼬레아우라")
                    .rating(0.0)
                    .description(description)
                    .genre("스릴러")
                    .timeLimitation(60)
                    .appropriatedPeople(3)
                    .cost(22000)
                    .imageURL("www.com")
                    .build();
        }
    }
}
