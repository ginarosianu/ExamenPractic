package Service;

import Domain.Car;
import Repository.IRepository;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private IRepository < Car > carRepository;

    public CarService (IRepository <Car> carRepository){

        this.carRepository = carRepository;
    }

    /**
     * adds a car
     *
     * @param id - car id
     * @param model- car model
     * @param kilometers -  number of kilometers of the car
     * @param price - daily price for rental
     */
    public void insert (String id, String model, int kilometers, double price){
        Car car = new Car (id, model, kilometers, price);
        carRepository.insert(car);
    }

    public List <Car> getAll(){
        return carRepository.getAll();
    }
}
