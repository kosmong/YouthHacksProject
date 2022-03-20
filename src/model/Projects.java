package model;

import exceptions.ProjectAlreadyRecordedException;
import exceptions.ProjectNotRecordedException;
import javafx.util.Pair;

import java.util.HashMap;

public class Projects {
    private HashMap<String, Project> projects;

    public Projects() {
        projects = new HashMap<>();
    }

    public void addProject(String projectName, String language) throws ProjectAlreadyRecordedException {
        if (projects.containsKey(projectName)) {
            throw new ProjectAlreadyRecordedException();
        } else {
            projects.put(projectName, new Project(projectName, language));
        }
    }

    public Project findProject(String projectName) throws ProjectNotRecordedException {
        Project project = projects.get(projectName);
        if (project == null) {
            throw new ProjectNotRecordedException();
        } else {
            return project;
        }
    }

    public Boolean noProject() {
        return projects.isEmpty();
    }

}
