package model;

import exceptions.*;

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
    public void addExperience(HardSkillTags experienceType, String experienceName) throws ExperienceAlreadyRecordedException {
        if (experienceType == HardSkillTags.WORKEXPERIENCE) {
            experiences.addWorkExperience(experienceName);
        } else if (experienceType == HardSkillTags.VOLUNTEEREXPERIENCE) {
            experiences.addVolunteerExperience(experienceName);
        } else if (experienceType == HardSkillTags.EXTRACURRICULARS) {
            experiences.addExtracurricular(experienceName);
        }
    }

    // add new project to projects and add the project to the used language
    // if language does not exist, create new entry of language and put the
    public void addProject(String projectName, String codingLanguage) throws LanguageNotRecordedException,
            LanguageAlreadyRecordedException, ProjectAlreadyRecordedException, ProjectNotRecordedException {

        projects.addProject(projectName, codingLanguage);
        Project myProject = projects.findProject(projectName);

        if (!languages.containsLanguage(codingLanguage)) {
            languages.addLanguage(codingLanguage);
        }

        languages.findLanguage(codingLanguage).addProject(myProject);
    }

    public CodingLanguage findLanguage(String language) throws LanguageNotRecordedException {
        return languages.findLanguage(language);
    }

    public Description findExperience(HardSkillTags type, String name) throws ExperienceNotRecordedException {
        if (type == HardSkillTags.WORKEXPERIENCE) {
            return experiences.findWorkExperience(name);
        } else if (type == HardSkillTags.VOLUNTEEREXPERIENCE) {
            return experiences.findVolunteerExperience(name);
        } else if (type == HardSkillTags.EXTRACURRICULARS) {
            return experiences.findExtracurricular(name);
        } else {
            throw new ExperienceNotRecordedException();
        }
    }

    public Project findProject(String projectName) throws ProjectNotRecordedException {
        return projects.findProject(projectName);
    }

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
