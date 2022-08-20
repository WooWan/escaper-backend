package escaper.backend.controller;

import escaper.backend.common.ApiRespon;
import escaper.backend.dto.MemberResponse;
import escaper.backend.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ApiRespon<MemberResponse> getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = auth.getName();
        MemberResponse memberResponse = memberService.getUser(name);
        return new ApiRespon<>(memberResponse);
    }
}
