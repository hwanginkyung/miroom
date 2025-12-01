package zero.miroom.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import zero.miroom.domain.Member;
import zero.miroom.domain.UserRole;
import zero.miroom.login.CustomUserDetails;
import zero.miroom.login.repository.MemberRepository;
import zero.miroom.login.service.MemberService;
import zero.miroom.service.UserSettingService;

import java.time.LocalDate;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
@Slf4j
public class UserController {
    private final UserSettingService userSettingService;
    private final MemberService memberService;
    private final MemberRepository memberRepository;


    @PostMapping("/role")
    public ResponseEntity<UserRole> UpdateName(@AuthenticationPrincipal CustomUserDetails user,
                                              @RequestParam UserRole role) {
        Long memberId= user.getId();
        userSettingService.updateMemberRole(memberId, role);
        return ResponseEntity.ok(role);
    }

    @PostMapping("/number")
    public ResponseEntity<String> UpdateBirthday(@AuthenticationPrincipal CustomUserDetails user,
                                                 @RequestParam String number) {
        Long memberId= user.getId();
        userSettingService.updateMemberNumber(memberId, number);
        return ResponseEntity.ok(number);
    }
    @PostMapping("/nickname")
    public ResponseEntity<String> UpdateAnniversary(@AuthenticationPrincipal CustomUserDetails user,
                                                    @RequestParam String nickname) {
        Long memberId= user.getId();
        Member member = memberRepository.findById(user.getId()).orElse(null);
        userSettingService.updateMemberNickName(memberId, nickname);
        return ResponseEntity.ok(nickname);
    }
    @PostMapping("/age")
    public ResponseEntity<Integer> UpdateAge(@AuthenticationPrincipal CustomUserDetails user,
                                                    @RequestParam int age) {
        Long memberId= user.getId();
        Member member = memberRepository.findById(user.getId()).orElse(null);
        userSettingService.updateMemberAge(memberId, age);
        return ResponseEntity.ok(age);
    }
    @PostMapping("/status")
    public ResponseEntity<String> UpdateStatus(@AuthenticationPrincipal CustomUserDetails user,
                                                    @RequestParam String status) {
        Long memberId= user.getId();
        Member member = memberRepository.findById(user.getId()).orElse(null);
        userSettingService.updateMemberStatus(memberId, status);
        return ResponseEntity.ok(status);
    }
}

