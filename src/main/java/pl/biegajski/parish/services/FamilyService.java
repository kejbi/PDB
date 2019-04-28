package pl.biegajski.parish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.biegajski.parish.model.entities.Family;
import pl.biegajski.parish.model.entities.Member;
import pl.biegajski.parish.repositories.FamilyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FamilyService {

    private FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public Optional<Family> findFamilyById(Long id){
        return familyRepository.findById(id);
    }

    public List<Family> getAllFamilies(){
        return familyRepository.findAll();
    }

    public void addMember(Member member, Long id){
       Optional<Family> family = familyRepository.findById(id);
       family.ifPresent(f ->{
            f.addMember(member);
            familyRepository.save(f);
       } );


    }
}
