package dev.akinaksoy.quadrigabe.services.rules;

import dev.akinaksoy.quadrigabe.dao.CarRepository;
import dev.akinaksoy.quadrigabe.services.dtos.requests.car.CreateCarRequests;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
@AllArgsConstructor
public class CarBusinessRules {

    private CarRepository carRepository;
    private static final int MAX_CAR_AGE = 20;

    public void checkIfPlateExist(String plate){
        if(this.carRepository.existsByPlate(plate)){
            throw new RuntimeException("You can't use the same plate twice.");
        }
    }

    public void checkIfMileageCounterLessThanZero(CreateCarRequests createCarRequests){
        if(createCarRequests.getMileageCounter() <= 0){
            throw new RuntimeException("Mileage counter can not be less than zero.");
        }
    }

    public void checkIfYearLessThan20Year(CreateCarRequests createCarRequests){
        int thisYear = Year.now().getValue();
        int maxAge = thisYear - MAX_CAR_AGE;
        int carYear = createCarRequests.getYear();

        if (carYear < 0) {
            throw new IllegalArgumentException("Year cannot be negative.");
        }

        if (carYear < maxAge) {
            throw new IllegalArgumentException("The car cannot be older than 20 years.");
        }

        System.out.println("The car is within the acceptable age range.");
    }

    public void checkIfPriceLessThanZero(CreateCarRequests createCarRequests){
        if(createCarRequests.getPrice() <= 0){
            throw new RuntimeException("Price can not be less than zero.");
        }
    }

}
