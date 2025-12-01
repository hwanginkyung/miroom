package zero.miroom.domain;

import jakarta.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String status;
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
}

