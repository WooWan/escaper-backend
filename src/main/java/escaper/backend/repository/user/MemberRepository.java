package escaper.backend.repository.user;

import escaper.backend.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserId(String userId);

    Optional<Member> findMemberByUserId(String userId);
}
