package Service;

import Domain.Rental.*;
import Domain.RentalValidatorException;
import Domain.Rental;
import Domain.Car;
import Repository.IRepository;

import java.awt.print.Book;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RentalService {
    private IRepository < Rental > rentalRepository;
    private IRepository < Car > carRepository;


    public RentalService(IRepository < Rental > rentalRepository, IRepository < Car > carRepository) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
    }

    /**
     * inserts a new rental;
     * @param id = rental id;
     * @param idCar = idCar of car for rent;
     * @param days = number of rent days
     * @param distance = distance of car rented
     * @throws RentalServiceException if movie is not on screens or movie id doesn't exist
     */

    public void insert(String id, String idCar, int days, int distance) {
        Car rentedCar = carRepository.getById(idCar);
        if (rentedCar == null) {
            throw new RentalServiceException("There is no car with given id" );
        }
        Rental rental = new Rental( id, idCar, days, distance );
        rentalRepository.insert(rental);
        carRepository.getById(idCar).setRentals(carRepository.getById(idCar).getRentals()+1);
    }

    public List < Rental > getAll() {
        return rentalRepository.getAll();
    }
}
