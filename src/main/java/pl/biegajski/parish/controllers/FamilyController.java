package pl.biegajski.parish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.biegajski.parish.model.entities.Family;
import pl.biegajski.parish.model.entities.Member;
import pl.biegajski.parish.services.FamilyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/family")
public class FamilyController {

    private FamilyService familyService;

    @Autowired
    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping
    public Optional<Family> findFamilyById(@RequestParam Long id){
        return familyService.findFamilyById(id);
    }

    @GetMapping("/all")
    public List<Family> getAllFamilies(){
        return familyService.getAllFamilies();
    }

    @PostMapping
    public void addMember(@RequestBody Member member, @RequestParam Long familyId){
        familyService.addMember(member, familyId);
    }

}
