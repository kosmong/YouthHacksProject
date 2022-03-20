package model;

import java.util.Set;

public class Project {
    private String projectName;
    private Description description;
    private String codingLanguage;

    public Project(String projectName, String language) {
        this.projectName = projectName;
        description = new Description(projectName + ", " + language);
        codingLanguage = language;
    }

    public String getProjectName() {
        return projectName;
    }

    public Description getDescription() {
        return description;
    }

    public String getCodingLanguage() {
        return codingLanguage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (!projectName.equals(project.projectName)) return false;
        if (!description.equals(project.description)) return false;
        return codingLanguage.equals(project.codingLanguage);
    }

    @Override
    public int hashCode() {
        int result = projectName.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + codingLanguage.hashCode();
        return result;
    }
}
