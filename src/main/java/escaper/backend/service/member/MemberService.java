package escaper.backend.service.member;

import escaper.backend.dto.MemberResponse;
import escaper.backend.entity.member.Member;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponse getUser(String userId) {
        Member findMember  = memberRepository.findByUserId(userId);
        return MemberConverter.toMemberResponse(findMember);
    }
}
