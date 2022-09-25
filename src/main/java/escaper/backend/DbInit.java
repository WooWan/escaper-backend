package escaper.backend;

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
//            em.flush();
//            em.clear();
        }

        public void dbInit2() {
            String 서울 = "서울";
            String 건대 = "건대";
            String 홍대 = "홍대";
            String 강남 = "강남";
            Cafe 키이스케이프 = createCafe("키이스케이프 홍대점", "010-7497-5517", new Address(서울, 홍대, "어울마당로 44-1", "보리수빌딩 지하 1층"));
            Theme 삐릿뽀 = createTheme(키이스케이프, "삐릿-뽀", "삐릿삐리.. 삐삐..삐.. 삐리리리리리!\n" +
                    "삐리리리릿 삐리리 삐릿뽀리 삐릿-뽀!", "미스터리", 75, 27000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8F%E1%85%B5%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%91%E1%85%B3/%E1%84%92%E1%85%A9%E1%86%BC%E1%84%83%E1%85%A2%E1%84%8C%E1%85%A5%E1%86%B7/%E1%84%88%E1%85%B5%E1%84%85%E1%85%B5%E1%86%BA%E1%84%88%E1%85%A9.jpeg");
            Theme 홀리데이 = createTheme(키이스케이프, "홀리데이", "오늘은 홀리데이.", "일상", 60, 23000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8F%E1%85%B5%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%91%E1%85%B3/%E1%84%92%E1%85%A9%E1%86%BC%E1%84%83%E1%85%A2%E1%84%8C%E1%85%A5%E1%86%B7/%E1%84%92%E1%85%A9%E1%86%AF%E1%84%85%E1%85%B5%E1%84%83%E1%85%A6%E1%84%8B%E1%85%B5.png");
            Theme 고백 = createTheme(키이스케이프, "고백", "아직도 기억나. 널 처음봤던 순간.\n" +
                    "가만히 서 있는 뒷모습조차 너무나도 귀여웠어.\n" +
                    "한눈에 알아차렸지. 우린 너무나 잘 맞을 거라는 걸.\n" +
                    "제대로 시작도 못해보고 널 이렇게 떠나보낼 수는 없어.\n" +
                    "지금, 만나러 갑니다.", "로맨스", 85, 28000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8F%E1%85%B5%E1%84%8B%E1%85%B5%E1%84%89%E1%85%B3%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5%E1%84%91%E1%85%B3/%E1%84%92%E1%85%A9%E1%86%BC%E1%84%83%E1%85%A2%E1%84%8C%E1%85%A5%E1%86%B7/%E1%84%80%E1%85%A9%E1%84%87%E1%85%A2%E1%86%A8.jpeg");

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


            Cafe 홍대_코드케이 = createCafe("코드케이 홍대점", "02-332-8842", new Address(서울, 홍대, "와우산로 64", "3층"));
            Theme 꼬레아우라 = createTheme(홍대_코드케이, "꼬레아 우라", "'2022년 대한민국은 현재 일본 식민지 시대'\n" +
                    "\n" +
                    "우리는 일본인들의 멸시와 차별 속에서\n" +
                    "하루하루 힘들게 살아가고 있다.\n" +
                    "\n" +
                    "어머니가 돌아가시고 그로부터 약 1년 후 문자 하나가 왔다.\n" +
                    "\n" +
                    "\"안녕하세요 저는 남자현이라고 합니다.\n" +
                    "어머님(안윤복)이 자녀분들에게 남겨주신 목걸이가 필요해요.\n" +
                    "내일 저녁 10시 홍대꾸에 있는 아시아믹스 술집\n" +
                    "2번 테이블에서 기다릴께요\"\n" +
                    "\n" +
                    "문득 1년 전 그날이 기억났다.\n" +
                    "\n" +
                    "다급하게 집에 들어오신 어머니\n" +
                    "그리고 내 손에 목걸이를 전해주시면서 하셨던 말\n" +
                    "\n" +
                    "\"엄마 지인이 목걸이를 찾으면 기억했다가 꼭 전해줘야 한다.\"\n" +
                    "\n" +
                    "그리고 다음날 어머님은 뺑소니 사고로 돌아가셨다.\n" +
                    "\n" +
                    "어머니의 마지막 유언이 돼버렸던 말...\n" +
                    "\n" +
                    "내일 나는 목걸이를 전해줘야 한다!\n" +
                    "\n" +
                    "*편한 복장을 권장합니다.(치마 비추천)\n" +
                    "-추천 인원은 3인 이상입니다.\n", "판타지", 75, 28000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%8F%E1%85%A9%E1%84%83%E1%85%B3%E1%84%8F%E1%85%A6%E1%84%8B%E1%85%B5-%E1%84%92%E1%85%A9%E1%86%BC%E1%84%83%E1%85%A2/%E1%84%81%E1%85%A9%E1%84%85%E1%85%A6%E1%84%8B%E1%85%A1+%E1%84%8B%E1%85%AE%E1%84%85%E1%85%A1.jpeg");

            Cafe 비트포비아_강남던전 = createCafe("비트포비아 강남던전", "02-555-4360", new Address(서울, 강남, "강남대로 84길 33", "대우디오빌플러스 지하1층 111호"));
            Theme 강남목욕탕 = createTheme(비트포비아_강남던전, "강남 목욕탕", "\"한 번 들어갔다 나오면 무조건 100% 피로가 회복되는 1인 강남목욕탕\"\n" +
                    "\n" +
                    "중요한 경기를 앞두고 완벽한 컨디션 관리를 위해서 강남목욕탕에 방문했는데,\n" +
                    "아뿔사! 오늘이 강남목욕탕 휴일이라니…\n" +
                    "이대로 돌아갈 순 없다.\n" +
                    "\n" +
                    "어떻게든 들어가서 최고의 컨디션을 만들어 나와야 한다!", "코믹", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%87%E1%85%B5%E1%84%90%E1%85%B3%E1%84%91%E1%85%A9%E1%84%87%E1%85%B5%E1%84%8B%E1%85%A1-%E1%84%80%E1%85%A1%E1%86%BC%E1%84%82%E1%85%A1%E1%86%B7%E1%84%83%E1%85%A5%E1%86%AB%E1%84%8C%E1%85%A5%E1%86%AB/illustration_%E1%84%80%E1%85%A1%E1%86%BC%E1%84%82%E1%85%A1%E1%86%B7%E1%84%86%E1%85%A9%E1%86%A8%E1%84%8B%E1%85%AD%E1%86%A8%E1%84%90%E1%85%A1%E1%86%BC.jpeg");
            Theme 대호시장_살인사건 = createTheme(비트포비아_강남던전, "대호시장 살인사건", "대호 시장에 위치한 집에서 한 남자의 사체가 발견된다.\n" +
                    "사인은 손목의 상처로 인한 과다출혈이었고,\n" +
                    "사체의 곁에서 유서가 발견되었기에 자살이라 보였다.\n" +
                    "\n" +
                    "하지만 이 사건이 단순한 자살이 아닌\n" +
                    "교묘하게 계획된 살인이 아닐까 의구심이 들기 시작한 당신은\n" +
                    "강력반 동료들과 함께 피해자와 관련된 사람들을 용의자로 지목해\n" +
                    "본격적으로 수사를 진행하기 시작하는데…\n", "추리", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%87%E1%85%B5%E1%84%90%E1%85%B3%E1%84%91%E1%85%A9%E1%84%87%E1%85%B5%E1%84%8B%E1%85%A1-%E1%84%80%E1%85%A1%E1%86%BC%E1%84%82%E1%85%A1%E1%86%B7%E1%84%83%E1%85%A5%E1%86%AB%E1%84%8C%E1%85%A5%E1%86%AB/%E1%84%83%E1%85%A2%E1%84%92%E1%85%A9%E1%84%89%E1%85%B5%E1%84%8C%E1%85%A1%E1%86%BC+%E1%84%89%E1%85%A1%E1%86%AF%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A1%E1%84%80%E1%85%A5%E1%86%AB.jpeg");
            Theme 마음을_그려드립니다 = createTheme(비트포비아_강남던전, "마음을 그려드립니다", "모든 감정에는 고유의 색이 있다는 것을 아시나요?\n" +
                    "\n" +
                    "지치는 일상 속에서 점점 바래져가는 마음들.\n" +
                    "그리고 그 마음을 어루만져 주고자 한 사람.\n" +
                    "\n" +
                    "감정의 색을 모아 당신의 '마음을 그려드립니다'.", "일상", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%87%E1%85%B5%E1%84%90%E1%85%B3%E1%84%91%E1%85%A9%E1%84%87%E1%85%B5%E1%84%8B%E1%85%A1-%E1%84%80%E1%85%A1%E1%86%BC%E1%84%82%E1%85%A1%E1%86%B7%E1%84%83%E1%85%A5%E1%86%AB%E1%84%8C%E1%85%A5%E1%86%AB/%E1%84%86%E1%85%A1%E1%84%8B%E1%85%B3%E1%86%B7%E1%84%8B%E1%85%B3%E1%86%AF+%E1%84%80%E1%85%B3%E1%84%85%E1%85%A7%E1%84%83%E1%85%B3%E1%84%85%E1%85%B5%E1%86%B8%E1%84%82%E1%85%B5%E1%84%83%E1%85%A1.jpeg");
            Theme 로스트킹덤 = createTheme(비트포비아_강남던전, "LOST KINGDOM : 잊혀진전설", "전설 속의 왕국, 아틀란티스는 과연 존재하는가?\n" +
                    "\n" +
                    "가문 대대로 아틀란티스에 관한 고고학 연구를 지속하고 있는\n" +
                    "키스콥 가문의 고고학자인 당신은\n" +
                    "어느 날 발신인을 알 수 없는 편지를 받게 된다.\n" +
                    "\n" +
                    "편지에는 놀랍게도 아틀란티스의 위치를 알리는 실마리가 적혀 있었고.\n" +
                    "실마리를 따라 도착한 곳은 버뮤다 해협에 있는 한 무인도의 좁은 동굴이었다.\n" +
                    "\n" +
                    "그곳에 도착한 당신은 동굴 안을 좀 더 자세히 살펴보기로 하는데…", "모험", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%87%E1%85%B5%E1%84%90%E1%85%B3%E1%84%91%E1%85%A9%E1%84%87%E1%85%B5%E1%84%8B%E1%85%A1-%E1%84%80%E1%85%A1%E1%86%BC%E1%84%82%E1%85%A1%E1%86%B7%E1%84%83%E1%85%A5%E1%86%AB%E1%84%8C%E1%85%A5%E1%86%AB/%E1%84%85%E1%85%A9%E1%84%89%E1%85%B3%E1%84%90%E1%85%B3%E1%84%8F%E1%85%B5%E1%86%BC%E1%84%83%E1%85%A5%E1%86%B7.jpeg");

            Cafe 디코더 = createCafe("홍대 디코더", "", new Address(서울, 홍대, "와우산로 88-1"));
            Theme INTROVERTED_THIEF = createTheme(디코더, "Introverted Thief", "벌써 세 번째 도난 신고, 그리고 도난 하루 전 그 장소에서 우연히 만났던 그녀.\n" +
                    "그녀는 나에게 옅은 미소과 함께 가볍게 인사를 건네고 사라졌다.\n" +
                    "아무런 단서도 없지만 당신의 촉각과 감이 그녀가 범인이라는 걸 말하고 있었다.\n" +
                    "\n" +
                    "지금부터 한 시간, 당신은 조사 끝에 알아 낸 그녀의 집에 몰래 들어가\n" +
                    "사건 전날 밤 일어난 일을 밝혀내고 그녀를 잡을 수 있는 단서를 찾아내야 한다.", "미스터리", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%B5%E1%84%8F%E1%85%A9%E1%84%83%E1%85%A5/introverted_thief.jpeg");
            Theme FURIOUS_REVENGE = createTheme(디코더, "Furious Revenge", "믿었던 회사의 배신, 그리고 복수.\n" +
                    "모든걸 함께 키워왔던 회사에서 한순간에 쫒겨나게 된 그는\n" +
                    "Revenge라 적혀있는 의문의 쪽지만을 남긴 채 사라지게 되고,\n" +
                    "그 이후로 회사의 시스템은 하나씩 마비되기 시작한다.\n" +
                    "\n" +
                    "그의 분노를 막기위해 사라져 버린 그의 방에서 단서를 찾아\n" +
                    "제일 중요한 서버의 해킹만은 막아야 한다.", "미스터리", 60, 22000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%B5%E1%84%8F%E1%85%A9%E1%84%83%E1%85%A5/Furious+revenge.jpeg");
            Theme Tempo_rubato = createTheme(디코더, "Tempo rubato", "어느날 아침,\n" +
                    "집 앞에 작은 상자가 하나 놓여 있었다.", "미스터리", 76, 28000, "https://escapertest.s3.ap-northeast-2.amazonaws.com/%E1%84%83%E1%85%B5%E1%84%8F%E1%85%A9%E1%84%83%E1%85%A5/tempo+rubato.png");
            Member member1 = new Member("user1", "username", "1234", "woohobi", ProviderType.GOOGLE, RoleType.USER);
            em.persist(member1);
            Post post1 = createPost("같이 홍대 방탈출 하러 갈 2명 구해요!!", "test", member1, LocalDate.of(2022,6,3), 삐릿뽀);
            em.persist(post1);
            Post post2 = createPost("주말 삐릿뽀 1명 구함", "test2", member1, LocalDate.of(2022, 10, 22), 홀리데이);
            Post post3 = createPost("평일 홍대에 시간 되시는분", "test2", member1, LocalDate.of(2022, 10, 22), 고백);
            Post post4 = createPost("방탈출 극쫄이 탱 구해요", "test2", member1, LocalDate.of(2022, 10, 22), 이불밖);
            Post post5 = createPost("양도 해주실 분 있나요?", "test2", member1, LocalDate.of(2022, 10, 22), 다시봄);
            em.persist(post2);
            em.persist(post3);
            em.persist(post4);
            em.persist(post5);


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
