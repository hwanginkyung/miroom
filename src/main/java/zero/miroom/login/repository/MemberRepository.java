package zero.miroom.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zero.miroom.domain.Member;


import java.util.Optional;

    public interface MemberRepository extends JpaRepository<Member, Long> {
        Optional<Member> findById(Long Id);
        //boolean existsByCoupleCode(String coupleCode);
        Optional<Member> findByKakaoId(Long kakaoId);
    }


