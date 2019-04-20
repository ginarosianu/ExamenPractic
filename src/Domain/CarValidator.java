package Domain;

import java.util.Calendar;

public class CarValidator implements IValidator <Car> {
    /**
     * validates a car
     *
     * @param car to validate
     * @throws CarValidator Exception is there validation error
     */

    public void validate(Car car) {
        String errors = "";
        if (car.getPrice() <= 0) {
            errors += "The price must be a positiv number, greater than zero.";
        }

        if (!errors.isEmpty()) {
            throw new CarValidatorException( errors );
        }

    }
}
