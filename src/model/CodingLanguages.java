package model;

import exceptions.LanguageAlreadyRecordedException;
import exceptions.LanguageNotRecordedException;

import java.util.HashMap;

public class CodingLanguages {
    private HashMap<String, Description> codingLanguages;

    public CodingLanguages() {
        codingLanguages = new HashMap<String, Description>();
    }

    public void addLanguage(String language) throws LanguageAlreadyRecordedException {
        if (codingLanguages.containsKey(language)) {
            throw new LanguageAlreadyRecordedException();
        } else {
            codingLanguages.put(language, new Description(language));
        }
    }

    public boolean containsLanguage(String language) {
        return codingLanguages.containsKey(language);
    }

    public Description getLanguageDescription(String language) throws LanguageNotRecordedException{
        if (codingLanguages.get(language) == null) {
            throw new LanguageNotRecordedException();
        } else {
            return codingLanguages.get(language);
        }
    }
}
