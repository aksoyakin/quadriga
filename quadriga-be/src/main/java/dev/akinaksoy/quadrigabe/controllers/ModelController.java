package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.ModelService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.model.CreateModelRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.model.UpdateModelRequest;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.CreatedModelResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.GetAllModelResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.GetModelByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.model.UpdateModelResponses;
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
@RequestMapping("api/v1/models")
@RequiredArgsConstructor
public class ModelController {

    private final ModelService modelService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedModelResponses createModel(@Valid @RequestBody CreateModelRequests requests){
        return modelService.createModel(requests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllModelResponses> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public GetModelByIdResponses getModelById(@PathVariable int id){
        return modelService.getModelById(id);
    }

    @PutMapping("/{id}")
    public UpdateModelResponses updateModelById(@RequestBody UpdateModelRequest requests,
                                                @PathVariable int id){
        return modelService.updateModelById(requests,id);
    }

    @DeleteMapping("/{id}")
    void deleteModelById(@PathVariable int id){
        modelService.deleteModelById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }

    @GetMapping("/findByName")
    public List<GetAllModelResponses> findModelByName(String name){
        return modelService.findModelByName(name);
    }
}
