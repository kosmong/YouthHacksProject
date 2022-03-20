package model;

import exceptions.*;

import java.util.Collection;
import java.util.Set;

public class ResumeOrganizer {
    private CodingLanguages languages;
    private Experiences experiences;
    private Projects projects;

    public ResumeOrganizer() {
        languages = new CodingLanguages();
        experiences = new Experiences();
        projects = new Projects();
    }

    // add new coding language
    public void addCodingLanguage(String language) throws LanguageAlreadyRecordedException {
        languages.addLanguage(language);
    }

    // add new experience depending on what type it is
    public void addExperience(HardSkillTags experienceType, String nameOfParty, String position) throws ExperienceAlreadyRecordedException {
        if (experienceType == HardSkillTags.WORKEXPERIENCE) {
            experiences.addWorkExperience(nameOfParty, position);
        } else if (experienceType == HardSkillTags.VOLUNTEEREXPERIENCE) {
            experiences.addVolunteerExperience(nameOfParty, position);
        } else if (experienceType == HardSkillTags.EXTRACURRICULARS) {
            experiences.addExtracurricular(nameOfParty, position);
        }
    }

    // add new project to projects and add the project to the used language
    // if language does not exist, create new entry of language and put the project in
    public void addProject(String projectName, String codingLanguage) throws LanguageNotRecordedException,
            LanguageAlreadyRecordedException, ProjectAlreadyRecordedException, ProjectNotRecordedException {

        projects.addProject(projectName, codingLanguage);
        Project myProject = projects.findProject(projectName, codingLanguage);

        if (!languages.containsLanguage(codingLanguage)) {
            languages.addLanguage(codingLanguage);
        }

        languages.findLanguage(codingLanguage).addProject(myProject);
    }

    // find coding language stored
    public CodingLanguage findLanguage(String language) throws LanguageNotRecordedException {
        return languages.findLanguage(language);
    }

    // find set of experiences that matches the name of party
    public Collection<? extends Experience> findExperiences(HardSkillTags type, String nameOfParty) throws ExperienceNotRecordedException {
        if (type == HardSkillTags.WORKEXPERIENCE) {
            return experiences.findWorkExperiences(nameOfParty);
        } else if (type == HardSkillTags.VOLUNTEEREXPERIENCE) {
            return experiences.findVolunteerExperiences(nameOfParty);
        } else if (type == HardSkillTags.EXTRACURRICULARS) {
            return experiences.findExtracurriculars(nameOfParty);
        } else {
            throw new ExperienceNotRecordedException();
        }
    }

    // find set of experiences that matches the name of party
    public Experience findExperience(HardSkillTags type, String nameOfParty, String position) throws ExperienceNotRecordedException {
        if (type == HardSkillTags.WORKEXPERIENCE) {
            return experiences.findWorkExperience(nameOfParty, position);
        } else if (type == HardSkillTags.VOLUNTEEREXPERIENCE) {
            return experiences.findVolunteerExperience(nameOfParty, position);
        } else if (type == HardSkillTags.EXTRACURRICULARS) {
            return experiences.findExtracurricular(nameOfParty, position);
        } else {
            throw new ExperienceNotRecordedException();
        }
    }

    // find set of projects that matches the project name
    public Set<Project> findProjects(String projectName) throws ProjectNotRecordedException {
        return projects.findProjects(projectName);
    }

    // find project with specific name and language
    public Project findProject(String projectName, String codingLanguage) throws ProjectNotRecordedException {
        return projects.findProject(projectName, codingLanguage);
    }

    // check if languages, experiences and projects are all empty
    public boolean allEmpty() {
        return languages.noLanguage() && experiences.allEmpty() && projects.noProject();
    }

    public CodingLanguages getLanguages() {
        return languages;
    }

    public Experiences getExperiences() {
        return experiences;
    }

    public Projects getProjects() {
        return projects;
    }
}
