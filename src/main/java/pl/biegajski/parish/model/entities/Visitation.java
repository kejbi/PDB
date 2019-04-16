package pl.biegajski.parish.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Visitation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long visitationId;

    private LocalDate dateOfVisitation;

    private String comments;

}
