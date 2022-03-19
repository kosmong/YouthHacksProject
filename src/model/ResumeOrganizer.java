package model;

import exceptions.ExperienceAlreadyRecordedException;
import exceptions.LanguageAlreadyRecordedException;
import exceptions.LanguageNotRecordedException;

public class ResumeOrganizer {
    public CodingLanguages languages;
    public Experiences experiences;
    public Projects projects;

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
    public void addProject(String projectName, String codingLanguage) throws LanguageNotRecordedException, LanguageAlreadyRecordedException {
        projects.addProject(projectName, codingLanguage);
        CodingLanguage language = languages.getLanguage(codingLanguage);
        Project myProject = projects.findProject(projectName);
        if (language == null) {
            languages.addLanguage(codingLanguage);
            languages.getLanguage(codingLanguage).addProject(myProject);
        } else {
            language.addProject(myProject);
        }
    }
}
