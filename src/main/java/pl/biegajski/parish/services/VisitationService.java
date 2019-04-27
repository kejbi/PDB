package pl.biegajski.parish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biegajski.parish.model.entities.Visitation;
import pl.biegajski.parish.repositories.VisitationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VisitationService {
    private VisitationRepository visitationRepository;

    @Autowired
    public VisitationService(VisitationRepository visitationRepository) {
        this.visitationRepository = visitationRepository;
    }

    public Optional<Visitation> findVisitationById(Long id){
        return visitationRepository.findById(id);
    }

    public List<Visitation> getAllVisitations(){
        return visitationRepository.findAll();
    }
}
