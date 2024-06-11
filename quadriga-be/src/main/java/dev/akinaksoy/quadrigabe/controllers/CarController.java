package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.CarService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.car.CreateCarRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.car.UpdateCarRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.CreateCarResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.GetAllCarResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.GetCarByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.car.UpdateCarResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1/cars")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CreateCarResponses createCar(CreateCarRequests createCarRequests){
        return carService.createCar(createCarRequests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    List<GetAllCarResponses> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    GetCarByIdResponses getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    @PutMapping("/{id}")
    UpdateCarResponses updateCarById(@RequestBody UpdateCarRequests requests,
                                     @PathVariable int id) {

        return carService.updateCarById(requests,id);
    }

    @DeleteMapping("/{id}")
    void deleteCarById(@PathVariable int id){
        carService.deleteCarById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }

    @GetMapping("/getByCategoryId")
    List<GetAllCarResponses> getCarByCategoryId(int categoryId){
        return carService.getCarByCategoryId(categoryId);
    }

    @GetMapping("/getByColorId")
    List<GetAllCarResponses> getCarByColorId(int colorId){
        return carService.getCarByColorId(colorId);
    }

    @GetMapping("/getByFuelTypeId")
    List<GetAllCarResponses> getCarByFuelTypeId(int fuelTypeId){
        return carService.getCarByFuelTypeId(fuelTypeId);
    }

    @GetMapping("/getByTransmissionTypeId")
    List<GetAllCarResponses> getCarByTransmissionTypeId(int transmissionType){
        return carService.getCarByTransmissionTypeId(transmissionType);
    }

    @GetMapping("/findByYear")
    List<GetAllCarResponses> findByYear(int year){
        return carService.findByYear(year);
    }

    @GetMapping("/findByPlate")
    List<GetAllCarResponses> findByPlate(String plate){
        return carService.findByPlate(plate);
    }

    @GetMapping("/findByMileageCounter")
    List<GetAllCarResponses> findByMileageCounter(int mileageCounter){
        return carService.findByMileageCounter(mileageCounter);
    }

    @GetMapping("/findByPrice")
    List<GetAllCarResponses> findByPrice(double price){
        return carService.findByPrice(price);
    }
}
