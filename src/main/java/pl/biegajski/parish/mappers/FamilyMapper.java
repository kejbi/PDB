package pl.biegajski.parish.mappers;

import org.springframework.stereotype.Component;
import pl.biegajski.parish.controllers.viewmodel.FamilyViewModel;
import pl.biegajski.parish.model.entities.Family;

@Component
public class FamilyMapper {

    public FamilyViewModel convertToViewModel(Family family){
        return new FamilyViewModel(family.getFamilyId(), family.getAddress(), family.getFamilyName());
    }

    public Family convertToEntity(FamilyViewModel familyViewModel){
        var family = new Family();
        family.setFamilyId(familyViewModel.getFamilyId());
        family.setAddress(familyViewModel.getAddress());
        family.setFamilyName(familyViewModel.getFamilyName());
        return family;
    }
}
