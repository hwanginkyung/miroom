package zero.miroom.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Member extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long kakaoId;
    private String name;
    private String email;
    UserRole role;
    private String nickname;
    private String number;
    private int age;
    private String password;
    private String status;
/*    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Photo> photos;*/

}
