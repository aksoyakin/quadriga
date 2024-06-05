package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.dao.ModelRepository;
import dev.akinaksoy.quadrigabe.entities.concretes.Model;
import dev.akinaksoy.quadrigabe.services.abstracts.ModelService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.model.CreateModelRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.model.UpdateModelRequest;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.CreatedModelResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.GetAllModelResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.GetModelByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.UpdateModelResponses;
import dev.akinaksoy.quadrigabe.services.rules.ModelBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelManager implements ModelService {

    private final ModelRepository modelRepository;
    private final ModelMapperService modelMapperService;
    private final ModelBusinessRules modelBusinessRules;

    @Override
    public CreatedModelResponses createModel(CreateModelRequests requests) {
        modelBusinessRules.checkIfName(requests.getName());

        Model model = this.modelMapperService.forRequest()
                .map(requests, Model.class);

        model.setId(0);
        modelRepository.save(model);

        CreatedModelResponses responses = this.modelMapperService.forResponse()
                .map(model, CreatedModelResponses.class);

        return responses;
    }

    @Override
    public List<GetAllModelResponses> getAllModels() {
        List<Model> models = modelRepository.findAll();

        List<GetAllModelResponses> responses = models.stream()
                .map(model -> modelMapperService.forResponse()
                .map(model,GetAllModelResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetModelByIdResponses getModelById(int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for tihs id: " + id));

        GetModelByIdResponses response = this.modelMapperService.forResponse()
                .map(model,GetModelByIdResponses.class);

        return response;
    }

    @Override
    public UpdateModelResponses updateModelById(UpdateModelRequest requests, int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for tihs id: " + id));

        Model updatedModel = modelMapperService.forRequest()
                .map(requests,Model.class);

        model.setId(id);
        model.setUpdatedDate(LocalDate.now());
        model.setName(updatedModel.getName() != null ? updatedModel.getName() : model.getName());
        modelRepository.save(model);

        UpdateModelResponses responses = modelMapperService.forResponse()
                .map(model, UpdateModelResponses.class);

        return responses;
    }

    @Override
    public void deleteModelById(int id) {
        Model model = modelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no model for tihs id: " + id));

        modelRepository.delete(model);
    }

    @Override
    public List<GetAllModelResponses> findModelByName(String name) {
        List<Model> models = modelRepository.findByName(name);
        List<GetAllModelResponses> responses = models.stream()
                .map(model -> this.modelMapperService.forResponse()
                .map(model, GetAllModelResponses.class))
                .collect(Collectors.toList());

        return responses;
    }
}