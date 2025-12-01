package zero.miroom.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class HomeworkSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 어떤 숙제(유형+교재)에 대한 세션인지
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "homework_item_id", nullable = false)
    private HomeworkItem homeworkItem;

    /**
     * 이 숙제가 유효한 날짜(예: 해당 주의 월요일)
     * - 주 단위로 관리하면 weekStartDate 느낌으로 써도 됨
     */
    @Column(nullable = false)
    private LocalDate targetDate;

    // ===== 범위 정보 =====
    // 페이지 기반일 수도, 단원(Day) 기반일 수도, 개수 기반일 수도 있으니
    // 문자열로 저장 + 단위 Enum 조합

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private RangeUnit rangeUnit;

    /**
     * 범위 텍스트 (예: "Day 7~10", "p.42~45", "틀린 문제 10개")
     */
    @Column(nullable = false, length = 100)
    private String rangeText;

    // 필요하다면 시작/끝 숫자도 따로 저장할 수 있음
    private Integer startNumber; // 페이지 시작 / 단원 시작 index
    private Integer endNumber;   // 페이지 끝 / 단원 끝 index
    private Integer count;       // 개수 기반인 경우 (오답 10개 등)

    // ===== 메모 =====
    @Lob
    private String memo; // 상시 있음

    // 진행 상태
    private Integer doneCount;   // 완료한 개수 (문제 수 등)
    private Boolean completed;   // 전부 완료 여부
}
