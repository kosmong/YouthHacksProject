package model;

public enum HardSkillTags {
    CODINGLANGUAGE("Coding Language"),
    EXTRACURRICULARS("Extracurriculars"),
    VOLUNTEEREXPERIENCE("Volunteer Experience"),
    WORKEXPERIENCE("Work Experience");

    private String tagName;

    HardSkillTags(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}
