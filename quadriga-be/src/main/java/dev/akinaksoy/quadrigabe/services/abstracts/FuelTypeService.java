package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype.CreateFuelTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype.UpdateFuelTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.CreatedFuelTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.GetAllFuelTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.GetFuelTypeByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.UpdateFuelTypeResponses;

import java.util.List;

public interface FuelTypeService {

    CreatedFuelTypeResponses createFuelType(CreateFuelTypeRequests requests);
    List<GetAllFuelTypeResponses> getAllFuelTypes();
    GetFuelTypeByIdResponses getFuelTypeById(int id);
    UpdateFuelTypeResponses updateFuelTypeById(UpdateFuelTypeRequests requests, int id);
    void deleteFuelTypeById(int id);
}
