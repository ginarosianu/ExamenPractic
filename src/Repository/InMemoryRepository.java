package Repository;

import Domain.Car;
import Domain.CarValidator;
import Domain.IValidator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRepository {

    private Map<String, Car > storage = new HashMap<>();
    private CarValidator validator;

    public InMemoryRepository(CarValidator validator) {
        this.validator = validator;
    }

    /**
     * inserts a car
     * @param car
     * @throws RepositoryException if an invoice with that id already exists
     */
    public void insert(Car car) {
        if (storage.containsKey(car.getId())) {
            throw new RepositoryException("A car with " + car.getId() + " already exists");
        }
        validator.validate(car);
        storage.put(car.getId(), car);
    }

    /**
     * @return a list with all cars
     */
    public List<Car> getAll() {
        return new ArrayList<>(storage.values());
    }

}
