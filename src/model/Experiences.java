package model;

import java.util.HashMap;

public class Experiences {
    public HashMap<String, Description> workExperience;
    public HashMap<String, Description> volunteerExperience;
    public HashMap<String, Description> extracurriculars;

    public Experiences() {
        workExperience = new HashMap<>();
        volunteerExperience = new HashMap<>();
        extracurriculars = new HashMap<>();
    }


}
