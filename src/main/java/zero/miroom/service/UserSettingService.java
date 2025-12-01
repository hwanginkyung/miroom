package zero.miroom.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zero.miroom.domain.Member;
import zero.miroom.domain.UserRole;
import zero.miroom.login.repository.MemberRepository;
import zero.miroom.login.service.MemberService;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserSettingService {
    private final MemberRepository memberRepository;
    private final MemberService memberService;
    @Transactional
    public void updateMemberRole(Long memberId, UserRole role) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        member.setRole(role);
    }
    @Transactional
    public void updateMemberNumber(Long memberId, String number) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        member.setNumber(number);
    }
    @Transactional
    public void updateMemberNickName(Long memberId, String nickname) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        member.setNickname(nickname);
    }
    @Transactional
    public void updateMemberAge(Long memberId, int age) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        member.setAge(age);
    }
    @Transactional
    public void updateMemberStatus(Long memberId, String status){
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        member.setStatus(status);
    }

}

