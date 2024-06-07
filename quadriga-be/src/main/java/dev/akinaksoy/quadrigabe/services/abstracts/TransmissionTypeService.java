package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.transmissiontype.CreateTransmissionTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.transmissiontype.UpdateTransmissionTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.CreatedTransmissionTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.GetAllTransmissionTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.GetTransmissionTypeByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.UpdateTransmissionTypeResponses;

import java.util.List;

public interface TransmissionTypeService {

    CreatedTransmissionTypeResponses createTransmissionType(CreateTransmissionTypeRequests requests);
    List<GetAllTransmissionTypeResponses> getAllTransmissionTypes();
    GetTransmissionTypeByIdResponses getTransmissionTypeById(int id);
    UpdateTransmissionTypeResponses updateTransmissionTypeById(UpdateTransmissionTypeRequests requests, int id);
    void deleteTransmissionTypeById(int id);
}
