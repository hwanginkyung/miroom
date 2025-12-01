package zero.miroom.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class HomeworkItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 이 숙제 주인 (학생 or 부모 계정 등)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private HomeworkType type;

    /**
     * 교재 이름 (예: 경선식 단어 1800, 올림포스1, 시험 대비 이그잼포유, 학생 노트 ...)
     */
    @Column(nullable = false, length = 100)
    private String materialName;

    /**
     * 기본 단위: PAGE / UNIT / COUNT
     * (타입에 따라 기본값 정해둘 수 있음)
     */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RangeUnit defaultRangeUnit;

    /**
     * 비활성화된 숙제 (더 이상 안 쓰는 교재 등)
     */
    @Column(nullable = false)
    private boolean active;
}
