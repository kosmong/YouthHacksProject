package model;

public class WorkExperience extends Experience{

    public WorkExperience(String companyName, String position) {
        super(companyName, position);
         description.addHardSkill(HardSkillTags.WORKEXPERIENCE);
    }
}
