package model;

public class ResumeOrganizer {
    public CodingLanguages languages;
    public Experiences experiences;

    public ResumeOrganizer() {
        languages = new CodingLanguages();
        experiences = new Experiences();
    }
}
