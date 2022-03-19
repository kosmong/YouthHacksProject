package Tests;

import model.Experiences;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class ExperiencesTest {
    private Experiences experiences;



    @Before
    public void startUp() {
        experiences = new Experiences();
    }

    @Test
    public void testPutOneExperience() {
        assertTrue(experiences.allEmpty());
    }
}
