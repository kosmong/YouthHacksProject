package Tests;
import exceptions.*;
import model.*;
import org.junit.Before;
import org.junit.Test;

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
        Description resultExperience = new Description(work);
        resultExperience.addHardSkill(HardSkillTags.WORKEXPERIENCE);
        Project resultProject = new Project(PROJECTNAME, JAVA);

        try {
            organizer.addCodingLanguage(JAVA);
            organizer.addExperience(HardSkillTags.WORKEXPERIENCE, work);
            organizer.addProject(PROJECTNAME, JAVA);
        } catch (LanguageAlreadyRecordedException | ExperienceAlreadyRecordedException | LanguageNotRecordedException |
                ProjectAlreadyRecordedException | ProjectNotRecordedException e) {
            fail("exception not Expected");
        }

        resultLanguage.addProject(resultProject);
        try {
            assertEquals(organizer.findLanguage(JAVA), resultLanguage);
            assertEquals(organizer.findExperience(HardSkillTags.WORKEXPERIENCE, work), resultExperience);
            assertEquals(organizer.findProject(PROJECTNAME), resultProject);
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
        resultLanguage1.addProject(resultProject2);

        try {
            organizer.addProject(PROJECTNAME, JAVA);
            assertEquals(organizer.findLanguage(JAVA), resultLanguage2);
        } catch (LanguageNotRecordedException | ProjectNotRecordedException | ProjectAlreadyRecordedException | LanguageAlreadyRecordedException e) {
            fail("exception not expected");
        }
    }
}
