package Domain;

public class Invoice {
    private String id;
    private int ammount;
    private String description;
    private String date;

    public Invoice(String id, int ammount, String description, String date) {
        this.id = id;
        this.ammount = ammount;
        this.description = description;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", ammount=" + ammount +
                ", description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
