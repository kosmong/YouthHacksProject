package Tests;
import model.Description;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
    public void testSetters() {
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
}
