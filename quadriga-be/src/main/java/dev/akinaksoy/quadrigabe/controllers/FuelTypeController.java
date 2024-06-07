package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.FuelTypeService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype.CreateFuelTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype.UpdateFuelTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.CreatedFuelTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.GetAllFuelTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.GetFuelTypeByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.UpdateFuelTypeResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/v1/fueltypes")
@RequiredArgsConstructor
public class FuelTypeController {
    
    private final FuelTypeService fuelTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedFuelTypeResponses createFuelType(@Valid @RequestBody CreateFuelTypeRequests requests){
        return fuelTypeService.createFuelType(requests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllFuelTypeResponses> getAllFuelTypes() {
        return fuelTypeService.getAllFuelTypes();
    }

    @GetMapping("/{id}")
    public GetFuelTypeByIdResponses getFuelTypeById(@PathVariable int id){
        return fuelTypeService.getFuelTypeById(id);
    }

    @PutMapping("/{id}")
    public UpdateFuelTypeResponses updateFuelTypeById(@RequestBody UpdateFuelTypeRequests requests,
                                                      @PathVariable int id){
        return fuelTypeService.updateFuelTypeById(requests,id);
    }

    @DeleteMapping("/{id}")
    void deleteFuelTypeById(@PathVariable int id){
        fuelTypeService.deleteFuelTypeById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }
}
