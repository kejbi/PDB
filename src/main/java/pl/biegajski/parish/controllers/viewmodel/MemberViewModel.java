package pl.biegajski.parish.controllers.viewmodel;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class MemberViewModel {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Pattern(regexp = "male|female")
    private String sex;

    @NotNull
    private String date;

    private String occupation;

    @NotNull
    private Long familyId;

    public MemberViewModel(Long id, String name, String surname, String sex, String date, String occupation, Long familyId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.date = date;
        this.occupation = occupation;
        this.familyId = familyId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }
}
