package pl.biegajski.parish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.biegajski.parish.controllers.viewmodel.FamilyViewModel;
import pl.biegajski.parish.mappers.FamilyMapper;
import pl.biegajski.parish.model.entities.Family;
import pl.biegajski.parish.services.FamilyService;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/family")
public class FamilyController {

    private FamilyService familyService;

    private FamilyMapper mapper;

    @Autowired
    public FamilyController(FamilyService familyService, FamilyMapper mapper) {
        this.familyService = familyService;
        this.mapper = mapper;
    }

    @GetMapping
    public FamilyViewModel findFamilyById(@RequestParam Long id){
        var family = familyService.findFamilyById(id).orElseThrow(EntityNotFoundException::new);
        return mapper.convertToViewModel(family);
    }

    @GetMapping("/all")
    public List<FamilyViewModel> getAllFamilies(){
        var families = familyService.getAllFamilies();

        return families.stream()
                .map(family -> mapper.convertToViewModel(family))
                .collect(Collectors.toList());
    }

    @PostMapping
    public Family saveFamily(@RequestBody @Valid FamilyViewModel familyViewModel, BindingResult bidingResult){
        if(bidingResult.hasErrors()){
            throw new ValidationException();
        }

        var family = mapper.convertToEntity(familyViewModel);

        return familyService.saveFamily(family);
    }

    @DeleteMapping
    public void deleteFamily(@RequestParam Long id){
        familyService.deleteFamily(id);
    }




}
