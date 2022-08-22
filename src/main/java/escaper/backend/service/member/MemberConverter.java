package escaper.backend.service.member;

import escaper.backend.dto.MemberResponse;
import escaper.backend.entity.member.Member;

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

}
