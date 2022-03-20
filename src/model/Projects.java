package model;

import exceptions.ProjectAlreadyRecordedException;
import exceptions.ProjectNotRecordedException;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Projects {
    private HashMap<Pair<String, String>, Project> projects;

    public Projects() {
        projects = new HashMap<>();
    }

    public void addProject(String projectName, String language) throws ProjectAlreadyRecordedException {
        if (projects.containsKey(new Pair<>(projectName, language))) {
            throw new ProjectAlreadyRecordedException();
        } else {
            projects.put(new Pair<>(projectName, language), new Project(projectName, language));
        }
    }

    // find all projects with given name no matter the language
    public Set<Project> findProjects(String projectName) throws ProjectNotRecordedException {
        Set<Project> projectSet = new HashSet<>();

        for (Map.Entry<Pair<String, String>, Project> project : projects.entrySet()) {
            if (project.getKey().getKey() == projectName) {
                projectSet.add(project.getValue());
            }
        }

        if (projectSet.isEmpty()) {
            throw new ProjectNotRecordedException();
        } else {
            return projectSet;
        }
    }

    // find project that has the same name and language
    public Project findProject(String projectName, String language) throws ProjectNotRecordedException{
        Project project = projects.get(new Pair<>(projectName, language));
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
