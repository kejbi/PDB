package pl.biegajski.parish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biegajski.parish.model.entities.Visitation;

@Repository
public interface VisitationRepository extends JpaRepository<Visitation, Long> {
}
