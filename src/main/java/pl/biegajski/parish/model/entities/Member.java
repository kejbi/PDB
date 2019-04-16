package pl.biegajski.parish.model.entities;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    private String name;

    private String surname;

    private Sex sex;

    private LocalDate dateOfBirth;

    private String occupation;

    @ManyToOne(fetch = FetchType.EAGER)
    private Family family;


}
