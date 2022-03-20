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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CodingLanguage)) return false;

        CodingLanguage language1 = (CodingLanguage) o;

        if (!language.equals(language1.language)) return false;
        if (!description.equals(language1.description)) return false;
        return projects.equals(language1.projects);
    }

    @Override
    public int hashCode() {
        int result = language.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + projects.hashCode();
        return result;
    }
}
