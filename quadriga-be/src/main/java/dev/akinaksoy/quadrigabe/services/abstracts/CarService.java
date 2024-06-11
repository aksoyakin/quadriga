package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.car.CreateCarRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.car.UpdateCarRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.CreateCarResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.GetAllCarResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.GetCarByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.UpdateCarResponses;

import java.util.List;

public interface CarService {

    CreateCarResponses createCar(CreateCarRequests createCarRequests);
    List<GetAllCarResponses> getAllCars();
    GetCarByIdResponses getCarById(int id);
    UpdateCarResponses updateCarById(UpdateCarRequests requests, int id);
    void deleteCarById(int id);
    List<GetAllCarResponses> getCarByCategoryId(int categoryId);
    List<GetAllCarResponses> getCarByColorId(int colorId);
    List<GetAllCarResponses> getCarByFuelTypeId(int fuelTypeId);
    List<GetAllCarResponses> getCarByTransmissionTypeId(int transmissionType);
    List<GetAllCarResponses> findByYear(int year);
    List<GetAllCarResponses> findByPlate(String plate);
    List<GetAllCarResponses> findByMileageCounter(int mileageCounter);
    List<GetAllCarResponses> findByPrice(double price);
}
