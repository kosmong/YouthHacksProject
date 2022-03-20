package model;

public class VolunteerExperience extends Experience{

    public VolunteerExperience(String organizationName, String position) {
        super(organizationName, position);
        description.addHardSkill(HardSkillTags.VOLUNTEEREXPERIENCE);
    }
}
