package Tests;
import exceptions.*;
import model.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ResumeOrganizerTest {
    private ResumeOrganizer organizer;
    private static final String JAVA = "Java";
    private static final String CPLUS = "C++";
    private static final String PROJECTNAME = "myproject";

    @Before
    public void startUp() {
        organizer = new ResumeOrganizer();
    }

    @Test
    public void testAddLanguageExperienceProjectOneEach() {
        assertTrue(organizer.allEmpty());

        CodingLanguage resultLanguage = new CodingLanguage(JAVA);
        String work = "work";
        String cat = "cat";
        Description resultExperience = new Description(work + ", " + cat);
        resultExperience.addHardSkill(HardSkillTags.WORKEXPERIENCE);
        Project resultProject = new Project(PROJECTNAME, JAVA);

        try {
            organizer.addCodingLanguage(JAVA);
            organizer.addExperience(HardSkillTags.WORKEXPERIENCE, work, cat);
            organizer.addProject(PROJECTNAME, JAVA);
        } catch (LanguageAlreadyRecordedException | ExperienceAlreadyRecordedException | LanguageNotRecordedException |
                ProjectAlreadyRecordedException | ProjectNotRecordedException e) {
            fail("exception not Expected");
        }

        resultLanguage.addProject(resultProject);
        try {
            assertEquals(organizer.findLanguage(JAVA), resultLanguage);
            assertEquals(organizer.findExperience(HardSkillTags.WORKEXPERIENCE, work, cat).getDescription(), resultExperience);
            assertEquals(organizer.findProject(PROJECTNAME, JAVA), resultProject);
        } catch (LanguageNotRecordedException | ExperienceNotRecordedException | ProjectNotRecordedException e) {
            fail("exception not expected");
        }
    }

    @Test
    public void testAddProjectNewLanguage() {
        Project resultProject1 = new Project(PROJECTNAME, CPLUS);
        CodingLanguage resultLanguage1 = new CodingLanguage(CPLUS);
        resultLanguage1.addProject(resultProject1);

        try {
            organizer.addProject(PROJECTNAME, CPLUS);
            assertEquals(organizer.findLanguage(CPLUS), resultLanguage1);
        } catch (LanguageNotRecordedException | ProjectNotRecordedException | ProjectAlreadyRecordedException | LanguageAlreadyRecordedException e) {
            fail("exception not expected");
        }

        Project resultProject2 = new Project(PROJECTNAME, JAVA);
        CodingLanguage resultLanguage2 = new CodingLanguage(JAVA);
        resultLanguage2.addProject(resultProject2);
        Set<Project> resultProjects = new HashSet<>();
        resultProjects.add(resultProject1);
        resultProjects.add(resultProject2);

        try {
            organizer.addProject(PROJECTNAME, JAVA);
            organizer.findLanguage(JAVA);
            assertEquals(organizer.findLanguage(JAVA), resultLanguage2);
            assertEquals(organizer.findProjects(PROJECTNAME), resultProjects);
        } catch (LanguageNotRecordedException | ProjectNotRecordedException | ProjectAlreadyRecordedException | LanguageAlreadyRecordedException e) {
            fail("exception not expected");
        }

        try {
            organizer.addProject(PROJECTNAME, CPLUS);
            fail("project already exception expected");
        } catch (LanguageNotRecordedException | LanguageAlreadyRecordedException | ProjectNotRecordedException e) {
            fail("these exceptions not expected");
        } catch (ProjectAlreadyRecordedException e) {
        }
    }
}
