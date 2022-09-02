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

//            Member member1 = new Member("user1", "username", "1234", ProviderType.GOOGLE, RoleType.USER);
//            Member member2 = new Member("user1", "username", "1234", ProviderType.GOOGLE, RoleType.USER);
//            em.persist(member1);
////            em.persist(user2);
//            Cafe cafe = new Cafe("키이스케이프", "010-1234-1234", new Address("서울", "성수"));
//            em.persist(cafe);
//
//            String description = " Production grade React applications that scale. The world's leading\n" +
//                    "          companies use Next.js by Vercel to build static and dynamic websites\n" +
//                    "          and web applications Welcome to the Next.js documentation! If you're\n" +
//                    "          new to Next.js, we recommend starting with the learn course. The\n" +
//                    "          interactive course with quizzes will guide you through everything you\n" +
//                    "          need to know to use Next.js. If you have questions about anything\n" +
//                    "          related to Next.js, you're always welcome to ask our community on\n" +
//                    "          GitHub Discussions.";
//
//            Theme theme1 = Theme.builder()
//                    .cafe(cafe)
//                    .name("꼬레아우라")
//                    .description(description)
//                    .rating(0.0)
//                    .genre("스릴러")
//                    .timeLimitation(60)
//                    .cost(22000)
//                    .imageURL("www.com")
//                    .build();
//            Theme theme2 = Theme.builder()
//                    .cafe(cafe)
//                    .name("꼬레아우라")
//                    .description(description)
//                    .rating(0.0)
//                    .genre("스릴러")
//                    .timeLimitation(60)
//                    .cost(22000)
//                    .imageURL("www.com")
//                    .build();
//            Theme theme3 = Theme.builder()
//                    .cafe(cafe)
//                    .name("꼬레아우라")
//                    .description(description)
//                    .rating(0.0)
//                    .genre("스릴러")
//                    .timeLimitation(60)
//                    .cost(22000)
//                    .imageURL("www.com")
//                    .build();
//            em.persist(theme1);
//            em.persist(theme2);
//            em.persist(theme3);
//
//
//            Post post1 = createPost("같이 홍대 방탈출 하러 갈 2명 구해요!!", "test", member1, LocalDate.of(2022,6,3));
//            post1.addTheme(theme1);
//
//
//            em.persist(post1);
//
//            em.flush();
//            em.clear();
        }

        public void dbInit2() {
            String 서울 = "서울";
            String 건대 = "건대";
            String 홍대 = "홍대";
            Cafe 키이스케이프 = createCafe("키이스케이프 홍대점", "010-7497-5517", new Address(서울, 홍대, "어울마당로 44-1", "보리수빌딩 지하 1층"));
            Theme theme = createTheme(키이스케이프, "삐릿-뽀", "삐릿삐리.. 삐삐..삐.. 삐리리리리리!\n" +
                    "삐리리리릿 삐리리 삐릿뽀리 삐릿-뽀!","미스터리",75 ,27000,"https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%88%E1%85%B5%E1%84%85%E1%85%B5%E1%86%BA%E1%84%88%E1%85%A9.jpeg" );
            Theme theme2 = createTheme(키이스케이프, "홀리데이", "오늘은 홀리데이.", "일상", 60, 23000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%92%E1%85%A9%E1%86%AF%E1%84%85%E1%85%B5%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5.jpeg");
            Theme theme3 = createTheme(키이스케이프, "고백", "아직도 기억나. 널 처음봤던 순간.\n" +
                    "가만히 서 있는 뒷모습조차 너무나도 귀여웠어.\n" +
                    "한눈에 알아차렸지. 우린 너무나 잘 맞을 거라는 걸.\n" +
                    "제대로 시작도 못해보고 널 이렇게 떠나보낼 수는 없어.\n" +
                    "지금, 만나러 갑니다.", "로맨스", 85, 28000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%80%E1%85%A9%E1%84%87%E1%85%A2%E1%86%A8.jpeg");

            Cafe 넥스트에디션_건대 = createCafe("넥스트에디션 건대점", "050-7417-6000", new Address(서울, 건대, "자양동 17-5", " "));
            Theme 다시봄 = createTheme(넥스트에디션_건대, "다시봄", "이건 아주 진부한 이야기입니다.", "일상", 80, 27000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%A1%E1%84%89%E1%85%B5%E1%84%87%E1%85%A9%E1%86%B7.jpeg");
            Theme 몬스터 = createTheme(넥스트에디션_건대, "몬스터", "\"내 안에 몬스터가 깨어나고 있어\"\n" +
                    "\n" +
                    "순간의 잘못된 선택이 커다란 악마를 만들어 냈다.\n" +
                    "1분 1초, 급박함과 긴장감 속에 서서히 닥쳐오는 재앙.\n" +
                    "내 손으로 만든 이 괴물은 내 손으로 직접 처리하겠어.\n" +
                    "끝을 모를 어둠 속에서, 점점 커져만 가는 몬스터를 막을 수 있을 것인가!", "미스터리", 70, 25000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%86%E1%85%A9%E1%86%AB%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5.jpeg");
            Theme 이불밖 = createTheme(넥스트에디션_건대, "이불밖은 위험해", "느지막한 주말 오후 이불속 당신!\n" +
                    "평소와는 다른 분위기에 이불 밖으로 나와보는데...", "일상", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%B5%E1%84%87%E1%85%AE%E1%86%AF%E1%84%87%E1%85%A1%E1%86%A9.jpeg");
            Theme 썸 = createTheme(넥스트에디션_건대, "썸", "친구라기엔 너무 가깝고,\n" +
                    "연인이라기엔 조금은 먼 우리.\n" +
                    "우리는.. 어떤 사이일까?", "로맨스", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8A%E1%85%A5%E1%86%B7.jpeg");
            Theme 아파트 = createTheme(넥스트에디션_건대, "B아파트 13동 1313호", "미스테리 동호회 \"블랙홀\"의 특별회원인 당신\n" +
                    "오늘밤 \"블랙홀\"의 첫 전국 정모가 열린다\n" +
                    "모임 장소는 일가족이 살해 했다는 저주받은 아파트\n" +
                    "일가족이 살해 당한 후 이사오는 사람마다 하루도 버티지 못하고 도망나온다는 저주받은 B아파트 13동 1313호아파트\n" +
                    "당신은 이곳에서 무사히 살아 나갈수 있을것인가.","공포", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8B%E1%85%A1%E1%84%91%E1%85%A1%E1%84%90%E1%85%B3.jpeg");
            Theme 소울체이서 = createTheme(넥스트에디션_건대, "SOUL CHASER", "소울 체이서란,\n" +
                    "이승에서 떠나지 못한 영혼들을 추적하여\n" +
                    "찾아내는 자들이다.\n" +
                    "이번 영혼에게는 어떠한 사연이 있는 것일까?", "야외", 90, 17000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/theme__%E1%84%89%E1%85%B5%E1%86%AF%E1%84%8C%E1%85%A9%E1%86%BC_%E1%84%91%E1%85%A9%E1%84%89%E1%85%B3%E1%84%90%E1%85%A5_SOUL+CHASER+-+%E1%84%89%E1%85%B5%E1%86%AF%E1%84%8C%E1%85%A9%E1%86%BC.jpeg");

        }

        public Theme createTheme(Cafe cafe, String name, String description, String genre, Integer timeLimitation, Integer cost, String url) {
            Theme theme = Theme.builder()
                    .cafe(cafe)
                    .name(name)
                    .rating(0.0)
                    .description(description)
                    .genre(genre)
                    .timeLimitation(timeLimitation)
                    .cost(cost)
                    .imageURL(url)
                    .build();
            em.persist(theme);
            return theme;
        }

        private Cafe createCafe(String name, String phone, Address address) {
            Cafe cafe = Cafe.builder()
                    .name(name)
                    .phoneNumber(phone)
                    .address(address)
                    .rating(0.0)
                    .build();
            em.persist(cafe);
            return cafe;
        }
    }
}
