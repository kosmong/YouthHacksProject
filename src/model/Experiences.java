package model;

import exceptions.ExperienceAlreadyRecordedException;

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
            workExperience.put(companyName, new Description(companyName));
        }
    }

    public void addVolunteerExperience(String organizationName) throws ExperienceAlreadyRecordedException{
        if (volunteerExperience.containsKey(organizationName)) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            volunteerExperience.put(organizationName, new Description(organizationName));
        }
    }

    public void addExtracurricular(String extracurricularType) throws ExperienceAlreadyRecordedException{
        if (extracurriculars.containsKey(extracurricularType)) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            extracurriculars.put(extracurricularType, new Description(extracurricularType));
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
