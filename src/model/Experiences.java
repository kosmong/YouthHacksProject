package model;

import exceptions.ExperienceAlreadyRecordedException;
import exceptions.ExperienceNotRecordedException;
import exceptions.ProjectNotRecordedException;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Experiences {
    private HashMap<Pair<String, String>, WorkExperience> workExperience;
    private HashMap<Pair<String, String>, VolunteerExperience> volunteerExperience;
    private HashMap<Pair<String, String>, Extracurricular> extracurriculars;

    public Experiences() {
        workExperience = new HashMap<>();
        volunteerExperience = new HashMap<>();
        extracurriculars = new HashMap<>();
    }

    // add description of work if it does not already exist
    public void addWorkExperience(String companyName, String position) throws ExperienceAlreadyRecordedException{
        if (workExperience.containsKey(new Pair<>(companyName, position))) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            workExperience.put(new Pair<>(companyName, position), new WorkExperience(companyName, position));
        }
    }

    // add description of volunteer if it does not exist
    public void addVolunteerExperience(String organizationName, String position) throws ExperienceAlreadyRecordedException{
        if (volunteerExperience.containsKey(new Pair<>(organizationName, position))) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            volunteerExperience.put(new Pair<>(organizationName, position), new VolunteerExperience(organizationName, position));
        }
    }

    // add description of extracurricular if it does not exist
    public void addExtracurricular(String extracurricularName, String position) throws ExperienceAlreadyRecordedException{
        if (extracurriculars.containsKey(new Pair<>(extracurricularName, position))) {
            throw new ExperienceAlreadyRecordedException();
        } else {
            extracurriculars.put(new Pair<>(extracurricularName, position), new Extracurricular(extracurricularName, position));
        }
    }

    // find all work done with a company
    public Set<WorkExperience> findWorkExperiences(String companyName) throws ExperienceNotRecordedException {
        Set<WorkExperience> workSet = new HashSet<>();

        for (Map.Entry<Pair<String, String>, WorkExperience> work : workExperience.entrySet()) {
            if (work.getKey().getKey() == companyName) {
                workSet.add(work.getValue());
            }
        }

        if (workSet.isEmpty()) {
            throw new ExperienceNotRecordedException();
        } else {
            return workSet;
        }
    }

    // find work done at a company in a particular position
    public WorkExperience findWorkExperience(String companyName, String position) throws ExperienceNotRecordedException{
        WorkExperience work = workExperience.get(new Pair<>(companyName, position));
        if (work == null) {
            throw new ExperienceNotRecordedException();
        } else {
            return work;
        }
    }

    // find all volunteer work done with an organization
    public Set<VolunteerExperience> findVolunteerExperiences(String organizationName) throws ExperienceNotRecordedException {
        Set<VolunteerExperience> volunteerSet = new HashSet<>();

        for (Map.Entry<Pair<String, String>, VolunteerExperience> volunteer : volunteerExperience.entrySet()) {
            if (volunteer.getKey().getKey() == organizationName) {
                volunteerSet.add(volunteer.getValue());
            }
        }

        if (volunteerSet.isEmpty()) {
            throw new ExperienceNotRecordedException();
        } else {
            return volunteerSet;
        }
    }

    // find volunteer work done at an organization in a particular position
    public VolunteerExperience findVolunteerExperience(String organizationName, String position) throws ExperienceNotRecordedException{
        VolunteerExperience volunteer = volunteerExperience.get(new Pair<>(organizationName, position));
        if (volunteer == null) {
            throw new ExperienceNotRecordedException();
        } else {
            return volunteer;
        }
    }

    // find all extracurricular of the particular name/kind
    public Set<Extracurricular> findExtracurriculars(String extracurricularName) throws ExperienceNotRecordedException {
        Set<Extracurricular> extracurricularSet = new HashSet<>();

        for (Map.Entry<Pair<String, String>, Extracurricular> extracurricular : extracurriculars.entrySet()) {
            if (extracurricular.getKey().getKey() == extracurricularName) {
                extracurricularSet.add(extracurricular.getValue());
            }
        }

        if (extracurricularSet.isEmpty()) {
            throw new ExperienceNotRecordedException();
        } else {
            return extracurricularSet;
        }
    }

    // find extracurricular in a particular position
    public Extracurricular findExtracurricular(String extracurricularName, String position) throws ExperienceNotRecordedException{
        Extracurricular extracurricular = extracurriculars.get(new Pair<>(extracurricularName, position));
        if (extracurricular == null) {
            throw new ExperienceNotRecordedException();
        } else {
            return extracurricular;
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

    public HashMap<Pair<String, String>, WorkExperience> getWorkExperience() {
        return workExperience;
    }

    public HashMap<Pair<String, String>, VolunteerExperience> getVolunteerExperience() {
        return volunteerExperience;
    }

    public HashMap<Pair<String, String>, Extracurricular> getExtracurriculars() {
        return extracurriculars;
    }
}
