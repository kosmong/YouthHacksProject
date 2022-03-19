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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Description)) return false;

        Description that = (Description) o;

        if (!name.equals(that.name)) return false;
        if (!time.equals(that.time)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
