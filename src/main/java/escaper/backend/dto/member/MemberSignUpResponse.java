package escaper.backend.dto.member;

import escaper.backend.entity.member.Member;
import escaper.backend.oauth.entity.ProviderType;
import escaper.backend.oauth.entity.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberSignUpResponse {
    private Long id;
    private String username;
    private String profileImageUrl;
    private ProviderType providerType;
    private RoleType roleType;
    private String redirectUrl;

    @Builder
    public MemberSignUpResponse(Member member, String redirectUrl) {
        this.id = member.getUserSeq();
        this.username = member.getUsername();
        this.profileImageUrl = member.getProfileImageUrl();
        this.providerType = member.getProviderType();
        this.roleType = member.getRoleType();
        this.redirectUrl = redirectUrl;
    }
}
