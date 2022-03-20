package model;

public class Extracurricular extends Experience{

    public Extracurricular(String extracurricularName, String position) {
        super(extracurricularName, position);
        description.addHardSkill(HardSkillTags.EXTRACURRICULARS);
    }
}
