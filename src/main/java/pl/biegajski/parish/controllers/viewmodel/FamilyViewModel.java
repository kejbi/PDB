package pl.biegajski.parish.controllers.viewmodel;

import javax.validation.constraints.NotNull;

public class FamilyViewModel {

    private Long familyId;

    @NotNull
    private String address;

    @NotNull
    private String familyName;


    public FamilyViewModel(Long familyId, @NotNull String address, @NotNull String familyName) {
        this.familyId = familyId;
        this.address = address;
        this.familyName = familyName;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }
}
