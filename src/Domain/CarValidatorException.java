package Domain;
public class CarValidatorException extends RuntimeException {
    public CarValidatorException(String message) {
        super ("CarValidatorException |||" + message);
    }
}
