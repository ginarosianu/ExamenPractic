package Service;

public class RentalServiceException extends RuntimeException {
    public RentalServiceException(String message){
        super("RentalServiceException ||| " + message);
    }
}
