package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.model.CreateModelRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.model.UpdateModelRequest;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.CreatedModelResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.GetAllModelResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.GetModelByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.UpdateModelResponses;

import java.util.List;

public interface ModelService {

    CreatedModelResponses createModel(CreateModelRequests requests);
    List<GetAllModelResponses> getAllModels();
    GetModelByIdResponses getModelById(int id);
    UpdateModelResponses updateModelById(UpdateModelRequest requests, int id);
    void deleteModelById(int id);
    List<GetAllModelResponses> findModelByName(String name);
}
