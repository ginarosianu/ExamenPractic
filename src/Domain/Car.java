package Domain;

public class Car extends Entity {
    private String id;
    private String model;
    private int kilometers;
    private double price;
    private int rentals;

    public Car(String id, String model, int kilometers, double price) {
        super(id);
        this.model = model;
        this.kilometers = kilometers;
        this.price = price;
        this.rentals=0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKilometers() {
        return kilometers;
    }

    public void setKilometers(int kilometers) {
        this.kilometers = kilometers;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRentals() { return rentals; }

    public void setRentals(int rentals) { this.rentals = rentals; }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", kilometers=" + kilometers +
                ", price=" + price +
                ", rentals=" + rentals +
                '}';
    }

}
