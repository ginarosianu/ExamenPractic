package Domain;

import java.util.Calendar;

public class RentalValidator {

public class BookingValidator implements IValidator<Rental> {
    /**
     * validates a rental
     */
    public void validate(Rental rental) {
        String errors = "";

        if (!errors.isEmpty()) {
            throw new RentalValidatorException( errors );
        }
    }
//        if (!booking.getId().equals(new StringBuilder(booking.getId()).reverse().toString())) {
//            throw new BookingValidatorException("Id must be a palindrome");
//        }


    }
}
