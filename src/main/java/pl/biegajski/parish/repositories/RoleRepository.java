package pl.biegajski.parish.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.biegajski.parish.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
