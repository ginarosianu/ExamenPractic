package Domain;

public class Rental extends Entity {

    private String idCar;
    private int days;
    private int distance;

    public Rental( String id, String idCar, int days, int distance) {
        super(id);
        this.idCar = idCar;
        this.days = days;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "idCar='" + idCar + '\'' +
                ", days=" + days +
                ", distance=" + distance +
                '}';
    }



    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }


}
