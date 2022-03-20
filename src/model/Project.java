package model;

import java.util.Set;

public class Project {
    private String projectName;
    private Description description;
    private String codingLanguage;

    public Project(String projectName, String language) {
        this.projectName = projectName;
        description = new Description(projectName);
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
}
