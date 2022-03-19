package model;

public class Descriptions {
    private String language;
    private AmountTime time;
    private String mySkills;

    public Descriptions(String language) {
        this.language = language;
        this.time = new AmountTime(0,0);
        this.mySkills = "";
    }

    public void setTime(int year, int month) {
        time.setYear(year);
        time.setMonth(month);
    }

    public void setDescription(String description) {
        this.mySkills = description;
    }
}
