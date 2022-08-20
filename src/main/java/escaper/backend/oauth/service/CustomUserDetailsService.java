package escaper.backend.oauth.service;

import escaper.backend.entity.member.Member;
import escaper.backend.oauth.entity.UserPrincipal;
import escaper.backend.repository.user.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member member = memberRepository.findByUserId(username);
        if (member == null) {
            throw new UsernameNotFoundException("Can not find username.");
        }
        return UserPrincipal.create(member);
    }
}
