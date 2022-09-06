package escaper.backend.service.member;

import escaper.backend.dto.member.MemberResponse;
import escaper.backend.dto.member.MemberSaveRequest;
import escaper.backend.dto.member.MemberSignUpResponse;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.member.TemporaryMember;
import escaper.backend.error.exception.MemberException;
import escaper.backend.repository.user.MemberRepository;
import escaper.backend.repository.user.TemporaryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final TemporaryMemberRepository temporaryMemberRepository;

    public MemberResponse getUser(String name) {
        Member findMember = memberRepository.findMemberByUserId(name)
                .orElseThrow(() -> MemberException.notFoundMember(name));

        return MemberConverter.toMemberResponse(findMember);
    }

    public MemberSignUpResponse signUpMember(MemberSaveRequest memberSaveRequest) {
        String email = memberSaveRequest.getEmail();
        Optional<TemporaryMember> result = temporaryMemberRepository.findTemporaryMemberByEmail(email);
        TemporaryMember temporaryMember = result.orElseThrow(MemberException::invalidSignup);

        Member member = memberRepository.save(MemberConverter.toMember(temporaryMember, memberSaveRequest));
        return MemberConverter.toMemberSignUpResponse(member, temporaryMember.getRedirectUrl());
    }
}
