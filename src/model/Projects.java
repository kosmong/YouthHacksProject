package model;

import javafx.util.Pair;

import java.util.HashMap;

public class Projects {
    private HashMap<String, Project> projects;

    public Projects() {
        projects = new HashMap<>();
    }

    public void addProject(String projectName, String language) {
        projects.put(projectName, new Project(projectName, language));
    }

    public Project findProject(String projectName) {
        return projects.get(projectName);
    }

    public Boolean noProject() {
        return projects.isEmpty();
    }

}
