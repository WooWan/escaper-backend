package escaper.backend.service.member;

import escaper.backend.dto.member.MemberResponse;
import escaper.backend.dto.member.MemberSaveRequest;
import escaper.backend.dto.member.MemberSignUpResponse;
import escaper.backend.entity.member.Member;
import escaper.backend.entity.member.TemporaryMember;

public class MemberConverter {

    public static MemberResponse toMemberResponse(Member member) {
        return MemberResponse.builder()
                .id(member.getUserSeq())
                .username(member.getUsername())
                .profileImageUrl(member.getProfileImageUrl())
                .providerType(member.getProviderType())
                .roleType(member.getRoleType())
                .build();
    }
    public static MemberSignUpResponse toMemberSignUpResponse(Member member, String redirectUrl) {
        return MemberSignUpResponse.builder()
                .member(member)
                .redirectUrl(redirectUrl)
                .build();
    }

    public static Member toMember(TemporaryMember temporaryMember, MemberSaveRequest memberSaveRequest) {
        return Member.builder()
                .username(memberSaveRequest.getNickname())
                .userId(temporaryMember.getUserId())
                .email(temporaryMember.getEmail())
                .providerType(temporaryMember.getProviderType())
                .roleType(temporaryMember.getRoleType())
                .profileImageUrl("")
                .build();
    }
}
