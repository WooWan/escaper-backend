package escaper.backend.entity.member;

import escaper.backend.oauth.entity.ProviderType;
import escaper.backend.oauth.entity.RoleType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class TemporaryMember {

    @Id
    @GeneratedValue
    private Integer id;

    private String email;
    private String userId;
    private ProviderType providerType;
    private RoleType roleType;
    private String redirectUrl;

    public TemporaryMember(String email, String userId, ProviderType providerType, RoleType roleType, String redirectUrl) {
        this.email = email;
        this.userId = userId;
        this.providerType = providerType;
        this.roleType = roleType;
        this.redirectUrl = redirectUrl;
    }

}
