package com.lietou.model;

public class TalentEducation {
    private Long id;

    private Long talentId;

    private String startDate;

    private String endDate;

    private String schoolName;

    private String professional;

    private String education;

    private String description;

    private Boolean f1;

    private Boolean f2;

    private Boolean f3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTalentId() {
        return talentId;
    }

    public void setTalentId(Long talentId) {
        this.talentId = talentId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName == null ? null : schoolName.trim();
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional == null ? null : professional.trim();
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Boolean getF1() {
        return f1;
    }

    public void setF1(Boolean f1) {
        this.f1 = f1;
    }

    public Boolean getF2() {
        return f2;
    }

    public void setF2(Boolean f2) {
        this.f2 = f2;
    }

    public Boolean getF3() {
        return f3;
    }

    public void setF3(Boolean f3) {
        this.f3 = f3;
    }
}