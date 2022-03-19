package Tests;

import exceptions.LanguageAlreadyRecordedException;
import model.CodingLanguages;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import static org.junit.Assert.fail;

public class CodingLanguagesTest {
    private CodingLanguages languages;

    @Before
    public void startUp() {
        languages = new CodingLanguages();
    }

    @Test
    public void testPutOneLanguage() {
        String Java = "Java";
        try {
            languages.addLanguage(Java);
        } catch (LanguageAlreadyRecordedException e) {
            fail("exception not expected");
        }

        Assert.assertTrue(languages.containsLanguage(Java));

        try {
            languages.addLanguage(Java);
            fail("exception expected");
        } catch (LanguageAlreadyRecordedException e) {
            Assert.assertTrue(languages.containsLanguage(Java));
        }
    }
}
