package model;

import exceptions.ExperienceAlreadyRecordedException;
import sun.security.krb5.internal.crypto.Des;

import java.util.HashMap;

public class Experiences {
    public HashMap<String, Description> workExperience;
    public HashMap<String, Description> volunteerExperience;
    public HashMap<String, Description> extracurriculars;

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

    public boolean noWorkExperience() {
        return workExperience.isEmpty();
    }

    public boolean noVolunteerExperience() {
        return volunteerExperience.isEmpty();
    }

    public boolean noExtrcurriculars() {
        return extracurriculars.isEmpty();
    }

    public boolean allEmpty() {
        return noWorkExperience() && noVolunteerExperience() && noExtrcurriculars();
    }

}
