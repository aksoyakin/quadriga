package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.dao.FuelTypeRepository;
import dev.akinaksoy.quadrigabe.entities.concretes.FuelType;
import dev.akinaksoy.quadrigabe.services.abstracts.FuelTypeService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype.CreateFuelTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype.UpdateFuelTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.CreatedFuelTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.GetAllFuelTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.GetFuelTypeByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype.UpdateFuelTypeResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuelTypeManager implements FuelTypeService {
    
    private final FuelTypeRepository fuelTypeRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreatedFuelTypeResponses createFuelType(CreateFuelTypeRequests requests) {
        FuelType fuelType = this.modelMapperService.forRequest()
                .map(requests, FuelType.class);

        fuelType.setId(0);
        fuelTypeRepository.save(fuelType);

        CreatedFuelTypeResponses responses = this.modelMapperService.forResponse()
                .map(fuelType, CreatedFuelTypeResponses.class);

        return responses;
    }

    @Override
    public List<GetAllFuelTypeResponses> getAllFuelTypes() {
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();

        List<GetAllFuelTypeResponses> responses = fuelTypes.stream()
                .map(fuelType -> modelMapperService.forResponse()
                        .map(fuelType,GetAllFuelTypeResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetFuelTypeByIdResponses getFuelTypeById(int id) {
        FuelType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Fuel Type for this id: " + id));

        GetFuelTypeByIdResponses response = this.modelMapperService.forResponse()
                .map(fuelType,GetFuelTypeByIdResponses.class);

        return response;
    }

    @Override
    public UpdateFuelTypeResponses updateFuelTypeById(UpdateFuelTypeRequests requests, int id) {
        FuelType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Fuel Type for this id: " + id));

        FuelType updatedFuelType = modelMapperService.forRequest()
                .map(requests,FuelType.class);

        fuelType.setId(id);
        fuelType.setUpdatedDate(LocalDate.now());
        fuelType.setType(updatedFuelType.getType() != null ? updatedFuelType.getType() : fuelType.getType());
        fuelTypeRepository.save(fuelType);

        UpdateFuelTypeResponses responses = modelMapperService.forResponse()
                .map(fuelType, UpdateFuelTypeResponses.class);

        return responses;
    }

    @Override
    public void deleteFuelTypeById(int id) {
        FuelType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Fuel Type for this id: " + id));

        fuelTypeRepository.delete(fuelType);
    }

}
