package escaper.backend.controller;

import escaper.backend.common.ApiRespon;
import escaper.backend.dto.member.MemberResponse;
import escaper.backend.dto.member.MemberSaveRequest;
import escaper.backend.dto.member.MemberSignUpResponse;
import escaper.backend.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ApiRespon<MemberResponse> getUser() {
        User principal =(User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = principal.getUsername();

        MemberResponse memberResponse = memberService.getUser(username);
        return new ApiRespon<>(memberResponse);
    }

    @PostMapping("/signUp")
    public MemberSignUpResponse signup(@RequestBody MemberSaveRequest memberSaveRequest) {
        return memberService.signUpMember(memberSaveRequest);
    }
}
