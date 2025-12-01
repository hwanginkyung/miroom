package zero.miroom.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String subject;
    private int careerYears;

    @OneToMany(mappedBy = "teacher")
    private List<Student> students = new ArrayList<>();
}

