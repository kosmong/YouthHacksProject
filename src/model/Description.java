package model;

public class Description {
    private String name;
    private AmountTime time;
    private String description;

    public Description(String name) {
        this.name = name;
        this.time = new AmountTime(0,0);
        this.description = "";
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

    public void setTime(int year, int month) {
        time.setYear(year);
        time.setMonth(month);
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
