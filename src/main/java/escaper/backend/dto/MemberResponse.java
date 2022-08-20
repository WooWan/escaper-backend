package escaper.backend.dto;

import escaper.backend.oauth.entity.ProviderType;
import escaper.backend.oauth.entity.RoleType;
import lombok.Builder;
import lombok.Data;

@Data
public class MemberResponse {

    private String userId;
    private String username;
    private String profileImageUrl;
    private ProviderType providerType;
    private RoleType roleType;

    @Builder
    public MemberResponse(String userId, String username, String profileImageUrl, ProviderType providerType, RoleType roleType) {
        this.userId = userId;
        this.username = username;
        this.profileImageUrl = profileImageUrl;
        this.providerType = providerType;
        this.roleType = roleType;
    }
}
