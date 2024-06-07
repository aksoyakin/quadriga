package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.dao.TransmissionTypeRepository;
import dev.akinaksoy.quadrigabe.entities.concretes.TransmissionType;
import dev.akinaksoy.quadrigabe.services.abstracts.TransmissionTypeService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.transmissiontype.CreateTransmissionTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.transmissiontype.UpdateTransmissionTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.CreatedTransmissionTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.GetAllTransmissionTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.GetTransmissionTypeByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.UpdateTransmissionTypeResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransmissionTypeManager implements TransmissionTypeService {
    
    private final TransmissionTypeRepository fuelTypeRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public CreatedTransmissionTypeResponses createTransmissionType(CreateTransmissionTypeRequests requests) {
        TransmissionType fuelType = this.modelMapperService.forRequest()
                .map(requests, TransmissionType.class);

        fuelType.setId(0);
        fuelTypeRepository.save(fuelType);

        CreatedTransmissionTypeResponses responses = this.modelMapperService.forResponse()
                .map(fuelType, CreatedTransmissionTypeResponses.class);

        return responses;
    }

    @Override
    public List<GetAllTransmissionTypeResponses> getAllTransmissionTypes() {
        List<TransmissionType> fuelTypes = fuelTypeRepository.findAll();

        List<GetAllTransmissionTypeResponses> responses = fuelTypes.stream()
                .map(fuelType -> modelMapperService.forResponse()
                        .map(fuelType,GetAllTransmissionTypeResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetTransmissionTypeByIdResponses getTransmissionTypeById(int id) {
        TransmissionType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Transmission Type for this id: " + id));

        GetTransmissionTypeByIdResponses response = this.modelMapperService.forResponse()
                .map(fuelType,GetTransmissionTypeByIdResponses.class);

        return response;
    }

    @Override
    public UpdateTransmissionTypeResponses updateTransmissionTypeById(UpdateTransmissionTypeRequests requests, int id) {
        TransmissionType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Transmission Type for this id: " + id));

        TransmissionType updatedTransmissionType = modelMapperService.forRequest()
                .map(requests,TransmissionType.class);

        fuelType.setId(id);
        fuelType.setUpdatedDate(LocalDate.now());
        fuelType.setType(updatedTransmissionType.getType() != null ? updatedTransmissionType.getType() : fuelType.getType());
        fuelTypeRepository.save(fuelType);

        UpdateTransmissionTypeResponses responses = modelMapperService.forResponse()
                .map(fuelType, UpdateTransmissionTypeResponses.class);

        return responses;
    }

    @Override
    public void deleteTransmissionTypeById(int id) {
        TransmissionType fuelType = fuelTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Transmission Type for this id: " + id));

        fuelTypeRepository.delete(fuelType);
    }

}
