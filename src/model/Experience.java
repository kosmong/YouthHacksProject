package model;

public abstract class Experience {
    protected String nameOfParty;
    protected String position;
    protected Description description;

    public Experience(String nameOfParty, String position) {
        this.nameOfParty = nameOfParty;
        this.position = position;
        description = new Description(nameOfParty + ", " + position);
    }

    public String getNameOfParty() {
        return nameOfParty;
    }

    public String getPosition() {
        return position;
    }

    public Description getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Experience)) return false;

        Experience that = (Experience) o;

        if (!nameOfParty.equals(that.nameOfParty)) return false;
        if (!position.equals(that.position)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = nameOfParty.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
