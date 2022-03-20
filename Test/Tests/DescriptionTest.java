package Tests;
import model.Description;
import model.HardSkillTags;
import model.SoftSkillTags;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DescriptionTest {
    private Description description;

    private static final String NAME = "New language";
    private static final int YEAR = 0;
    private static final int MONTH = 3;
    private static final String DESCRIBE = "new description";

    @Before
    public void startUp() {
        description = new Description(NAME);
    }

    @Test
    public void testGettersAndSetters() {
        assertTrue(description.getName() == NAME);
        assertTrue(description.getDescription() == "");
        assertTrue(description.getTime().getYear() == 0);
        assertTrue(description.getTime().getMonth() == 0);

        description.setTime(YEAR, MONTH);
        assertTrue(description.getTime().getYear() == YEAR);
        assertTrue(description.getTime().getMonth() == MONTH);

        description.setDescription(DESCRIBE);
        assertTrue(description.getDescription() == DESCRIBE);
    }

    @Test
    public void testMultipleEdits() {
        Description result = new Description(NAME);
        assertEquals(description, result);

        result.addHardSkill(HardSkillTags.CODINGLANGUAGE);
        result.addSoftSkill(SoftSkillTags.LEADERSHIP);
        result.addSoftSkill(SoftSkillTags.TEAMENVIRONMENT);

        description.addHardSkill(HardSkillTags.CODINGLANGUAGE);
        description.addSoftSkill(SoftSkillTags.LEADERSHIP);
        description.addSoftSkill(SoftSkillTags.TEAMENVIRONMENT);

        assertEquals(description, result);

        result.setDescription(DESCRIBE);
        description.setDescription(DESCRIBE);

        assertEquals(description, result);

        result.setDescription("meow");
        description.setDescription("meow");

        assertEquals(description, result);

        result.setTime(YEAR, MONTH);
        description.setTime(YEAR, MONTH);

        assertEquals(description, result);

        result.setTime(MONTH, YEAR);
        description.setTime(MONTH, YEAR);

        assertEquals(description, result);
    }
}
