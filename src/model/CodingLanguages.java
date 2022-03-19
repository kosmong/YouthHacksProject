package model;

import exceptions.LanguageAlreadyRecordedException;

import java.util.HashMap;

public class CodingLanguages {
    private HashMap<String, Descriptions> codingLanguages;

    public CodingLanguages() {
        codingLanguages = new HashMap<String, Descriptions>();
    }

    public void addLanguage(String language) throws LanguageAlreadyRecordedException {
        if (codingLanguages.containsKey(language)) {
            throw new LanguageAlreadyRecordedException();
        } else {
            codingLanguages.put(language, new Descriptions(language));
        }
    }

    public boolean containsLanguage(String language) {
        return codingLanguages.containsKey(language);
    }
}
