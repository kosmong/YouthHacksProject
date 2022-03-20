package model;

import java.util.HashSet;
import java.util.Set;

public class CodingLanguage {
    private String language;
    private Description description;
    private Set<Project> projects;

    public CodingLanguage(String language) {
        this.language = language;
        this.description = new Description(language);
        this.description.addHardSkill(HardSkillTags.CODINGLANGUAGE);
        this.projects = new HashSet<>();
    }

    public String getLanguage() {
        return language;
    }

    public Description getDescription() {
        return description;
    }

    public void addProject(Project project) {
        projects.add(project);
    }
}
