package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.entities.concretes.Car;
import dev.akinaksoy.quadrigabe.dao.CarRepository;
import dev.akinaksoy.quadrigabe.services.abstracts.CarService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.car.CreateCarRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.car.UpdateCarRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.CreateCarResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.GetAllCarResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.GetCarByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.UpdateCarResponses;
import dev.akinaksoy.quadrigabe.services.rules.CarBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final ModelMapperService modelMapperService;
    private final CarBusinessRules carBusinessRules;


    @Override
    public CreateCarResponses createCar(CreateCarRequests createCarRequests) {
        this.carBusinessRules.checkIfPlateExist(createCarRequests.getPlate());
        this.carBusinessRules.checkIfMileageCounterLessThanZero(createCarRequests);
        this.carBusinessRules.checkIfYearLessThan20Year(createCarRequests);
        this.carBusinessRules.checkIfPriceLessThanZero(createCarRequests);

        Car car = this.modelMapperService.forRequest()
                .map(createCarRequests, Car.class);

        car.setId(0);
        carRepository.save(car);

        CreateCarResponses responses = this.modelMapperService.forResponse()
                .map(car, CreateCarResponses.class);

        return responses;
    }

    @Override
    public List<GetAllCarResponses> getAllCars() {
        List<Car> cars = carRepository.findAll();

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> modelMapperService.forResponse()
                .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetCarByIdResponses getCarById(int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this id: " + id));

        GetCarByIdResponses responses = this.modelMapperService.forResponse()
                .map(car, GetCarByIdResponses.class);

        return responses;
    }

    @Override
    public UpdateCarResponses updateCarById(UpdateCarRequests requests, int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this id: " + id));

        Car updatedCar = modelMapperService.forRequest()
                .map(requests, Car.class);

        car.setId(id);
        car.setUpdatedDate(LocalDate.now());
        car.setPrice(updatedCar.getPrice());
        car.setYear(updatedCar.getYear());
        car.setMileageCounter(updatedCar.getMileageCounter());
        car.setPlate(updatedCar.getPlate());
        car.setDescription(updatedCar.getDescription());
        car.setSeatingCapacity(updatedCar.getSeatingCapacity());
        car.setAvailable(updatedCar.isAvailable());
        carRepository.save(car);

        UpdateCarResponses responses = modelMapperService.forResponse()
                .map(car, UpdateCarResponses.class);

        return responses;
    }

    @Override
    public void deleteCarById(int id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no car for this id: " + id));

        this.carRepository.delete(car);
    }

    @Override
    public List<GetAllCarResponses> getCarByCategoryId(int categoryId) {
        List<Car> cars = carRepository.findByCategoryId(categoryId);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> getCarByColorId(int colorId) {
        List<Car> cars = carRepository.findByColorId(colorId);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> getCarByFuelTypeId(int fuelTypeId) {
        List<Car> cars = carRepository.findByFuelTypeId(fuelTypeId);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> getCarByTransmissionTypeId(int transmissionType) {
        List<Car> cars = carRepository.findByTransmissionTypeId(transmissionType);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> findByYear(int year) {
        List<Car> cars = carRepository.findByYear(year);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> findByPlate(String plate) {
        List<Car> cars = carRepository.findByPlate(plate);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> findByMileageCounter(int mileageCounter) {
        List<Car> cars = carRepository.findByMileageCounter(mileageCounter);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public List<GetAllCarResponses> findByPrice(double price) {
        List<Car> cars = carRepository.findByPrice(price);

        List<GetAllCarResponses> responses = cars.stream()
                .map(car -> this.modelMapperService.forResponse()
                        .map(car, GetAllCarResponses.class))
                .collect(Collectors.toList());

        return responses;
    }
}
