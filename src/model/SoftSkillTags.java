package model;


public enum SoftSkillTags {
    ATTENTIONTODETAIL("Attention to Detail"),
    COMMUNICATIONSKILL("Communication Skill"),
    LEADERSHIP("Leadership"),
    PROBLEMSOLVING("Problem Solving"),
    TEAMENVIRONMENT("Team Environment"),
    TIMEMANAGEMENT("Time Management");



    private String tagName;

    SoftSkillTags(String tagName) {
        this.tagName = tagName;
    }

    public String getTagName() {
        return tagName;
    }
}
