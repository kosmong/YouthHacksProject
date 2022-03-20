package Tests;
import model.Description;
import model.HardSkillTags;
import model.ResumeOrganizer;
import model.SoftSkillTags;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ResumeOrganizerTest {
    ResumeOrganizer organizer;

    @Before
    public void startUp() {
        organizer = new ResumeOrganizer();
    }

    @Test
    public void testAddLanguageExperienceProjectOne() {
        assertTrue(organizer.allEmpty());


    }
}
