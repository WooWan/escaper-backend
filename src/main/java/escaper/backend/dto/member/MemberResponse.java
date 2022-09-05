package escaper.backend.dto.member;

import escaper.backend.oauth.entity.ProviderType;
import escaper.backend.oauth.entity.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberResponse {

    private Long id;
    private String username;
    private String profileImageUrl;
    private ProviderType providerType;
    private RoleType roleType;

//    @Builder
//    public MemberResponse(Long id, String username, String profileImageUrl, ProviderType providerType, RoleType roleType) {
//        this.id = id;
//        this.username = username;
//        this.profileImageUrl = profileImageUrl;
//        this.providerType = providerType;
//        this.roleType = roleType;
//    }

    @Builder
    public MemberResponse(Long id, String username, String profileImageUrl, ProviderType providerType, RoleType roleType) {
        this.id = id;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
        this.providerType = providerType;
        this.roleType = roleType;
    }
}
