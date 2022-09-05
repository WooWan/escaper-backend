package escaper.backend.oauth.entity;

import escaper.backend.entity.member.Member;
import escaper.backend.oauth.info.OAuth2UserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class UserPrincipal implements OAuth2User, UserDetails, OidcUser {
    private final String userId;
    private final ProviderType providerType;
    private final RoleType roleType;
    private final Collection<GrantedAuthority> authorities;
    private Map<String, Object> attributes;

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getName() {
        return userId;
    }

    @Override
    public String getUsername() {
        return userId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Map<String, Object> getClaims() {
        return null;
    }

    @Override
    public OidcUserInfo getUserInfo() {
        return null;
    }

    @Override
    public OidcIdToken getIdToken() {
        return null;
    }

    public ProviderType getProviderType(){
        return providerType;
    }
    public RoleType getRoleType() {
        return roleType;
    }

    public static UserPrincipal create(Member member) {
        return new UserPrincipal(
                member.getUserId(),
                member.getProviderType(),
                RoleType.USER,
                Collections.singletonList(new SimpleGrantedAuthority(RoleType.USER.getCode()))
        );
    }

    public static UserPrincipal create(OAuth2UserInfo userInfo, ProviderType providerType) {
        return new UserPrincipal(
                userInfo.getId(),
                providerType,
                RoleType.USER,
                Collections.singletonList(new SimpleGrantedAuthority(RoleType.USER.getCode()))
        );
    }

//    public static UserPrincipal create(Member member, Map<String, Object> attributes) {
//        UserPrincipal userPrincipal = create(member);
//        userPrincipal.setAttributes(attributes);
//
//        return userPrincipal;
//    }
    public static UserPrincipal create(OAuth2UserInfo userInfo, ProviderType providerType, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = create(userInfo, providerType);
        userPrincipal.setAttributes(attributes);

        return userPrincipal;
    }
}

