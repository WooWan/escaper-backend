package escaper.backend.repository.user;


import escaper.backend.entity.member.TemporaryMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TemporaryMemberRepository extends JpaRepository<TemporaryMember, Integer> {

    Optional<TemporaryMember> findTemporaryMemberByEmail(String email);
}
