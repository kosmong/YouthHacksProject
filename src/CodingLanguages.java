
import java.util.HashMap;

public class CodingLanguages {
    private HashMap<String, Descriptions> codingLanguages;

    public CodingLanguages() {
        codingLanguages = new HashMap<String, Descriptions>();
    }

    public void addLanguage(String language) {
        if (codingLanguages.containsKey(language)) {
            // throw languageAlreadyRecordedException;
        } else {
            codingLanguages.put(language, new Descriptions(language));
        }
    }
}
