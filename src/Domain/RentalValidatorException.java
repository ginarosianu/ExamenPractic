package Domain;
public class RentalValidatorException extends RuntimeException {
    public RentalValidatorException(String message) {
        super ("RentalValidatorException |||" + message);
    }
}
