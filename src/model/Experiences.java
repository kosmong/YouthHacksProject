package model;

import exceptions.ExperienceAlreadyRecordedException;
import exceptions.ExperienceNotRecordedException;
import sun.security.krb5.internal.crypto.Des;

import java.util.HashMap;

public class Experiences {
    private HashMap<String, Description> workExperience;
    private HashMap<String, Description> volunteerExperience;
    private HashMap<String, Description> extracurriculars;

    public Experiences() {
        workExperience = new HashMap<>();
        volunteerExperience = new HashMap<>();
        extracurriculars = new HashMap<>();
    }

    public void addWorkExperience(String companyName) throws ExperienceAlreadyRecordedException{
        if (workExperience.containsKey(companyName)) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            Description description = new Description(companyName);
            description.addHardSkill(HardSkillTags.WORKEXPERIENCE);
            workExperience.put(companyName, description);
        }
    }

    public void addVolunteerExperience(String organizationName) throws ExperienceAlreadyRecordedException{
        if (volunteerExperience.containsKey(organizationName)) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            Description description = new Description(organizationName);
            description.addHardSkill(HardSkillTags.VOLUNTEEREXPERIENCE);
            volunteerExperience.put(organizationName, description);
        }
    }

    public void addExtracurricular(String extracurricularName) throws ExperienceAlreadyRecordedException{
        if (extracurriculars.containsKey(extracurricularName)) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            Description description = new Description(extracurricularName);
            description.addHardSkill(HardSkillTags.EXTRACURRICULARS);
            extracurriculars.put(extracurricularName, description);
        }
    }

    public Description findWorkExperience(String companyName) throws ExperienceNotRecordedException {
        Description description = workExperience.get(companyName);
        if (description == null) {
            throw new ExperienceNotRecordedException();
        } else {
            return description;
        }
    }

    public Description findVolunteerExperience(String organizationName) throws ExperienceNotRecordedException {
        Description description = volunteerExperience.get(organizationName);
        if (description == null) {
            throw new ExperienceNotRecordedException();
        } else {
            return description;
        }
    }

    public Description findExtracurricular(String extracurricularName) throws ExperienceNotRecordedException {
        Description description = extracurriculars.get(extracurricularName);
        if (description == null) {
            throw new ExperienceNotRecordedException();
        } else {
            return description;
        }
    }

    public boolean noWorkExperience() {
        return workExperience.isEmpty();
    }

    public boolean noVolunteerExperience() {
        return volunteerExperience.isEmpty();
    }

    public boolean noExtracurriculars() {
        return extracurriculars.isEmpty();
    }

    public boolean allEmpty() {
        return noWorkExperience() && noVolunteerExperience() && noExtracurriculars();
    }

}
