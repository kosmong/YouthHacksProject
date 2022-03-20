package model;

import java.util.HashSet;
import java.util.Set;

public class Description {
    private String name;
    private AmountTime time;
    private String description;
    private Set<HardSkillTags> hardSkills;
    private Set<SoftSkillTags> softSkills;


    public Description(String name) {
        this.name = name;
        this.time = new AmountTime(0,0);
        this.description = "";
        this.hardSkills = new HashSet<>();
        this.softSkills = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public AmountTime getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public Set<HardSkillTags> getHardSkills() {
        return hardSkills;
    }

    public Set<SoftSkillTags> getSoftSkills() {
        return softSkills;
    }

    public void setTime(int year, int month) {
        time.setYear(year);
        time.setMonth(month);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addHardSkill(HardSkillTags tag) {
        hardSkills.add(tag);
    }

    public void addSoftSkill(SoftSkillTags tag) {
        softSkills.add(tag);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;

        Description that = (Description) o;

        if (!name.equals(that.name)) return false;
        if (!time.equals(that.time)) return false;
        if (!description.equals(that.description)) return false;
        if (!hardSkills.equals(that.hardSkills)) return false;
        return softSkills.equals(that.softSkills);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + hardSkills.hashCode();
        result = 31 * result + softSkills.hashCode();
        return result;
    }
}
