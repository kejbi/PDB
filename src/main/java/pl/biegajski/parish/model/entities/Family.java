package pl.biegajski.parish.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long familyId;

    private String address;

    private String familyName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "family")
    private List<Member> members;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    private List<Visitation> visitations;

}
