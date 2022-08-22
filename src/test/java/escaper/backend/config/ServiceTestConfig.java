package escaper.backend.config;

import escaper.backend.entity.member.Member;
import escaper.backend.oauth.entity.ProviderType;
import escaper.backend.oauth.entity.RoleType;
import escaper.backend.repository.user.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ServiceTestConfig {

    @Autowired
    protected MemberRepository memberRepository;

    protected Member member;

    @BeforeEach
    void init() {
        this.member = memberRepository.save(
                Member.builder()
                        .username("username")
                        .profileImageUrl("www.com")
                        .providerType(ProviderType.GOOGLE)
                        .roleType(RoleType.USER)
                        .build()
        );
    }
}
