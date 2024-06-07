package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.TransmissionTypeService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.transmissiontype.CreateTransmissionTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.transmissiontype.UpdateTransmissionTypeRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.CreatedTransmissionTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.GetAllTransmissionTypeResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.GetTransmissionTypeByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype.UpdateTransmissionTypeResponses;
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
@RequestMapping("api/v1/transmissiontypes")
@RequiredArgsConstructor
public class TransmissionTypeController {

    private final TransmissionTypeService transmissionTypeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedTransmissionTypeResponses createTransmissionType(@Valid @RequestBody CreateTransmissionTypeRequests requests){
        return transmissionTypeService.createTransmissionType(requests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllTransmissionTypeResponses> getAllTransmissionTypes() {
        return transmissionTypeService.getAllTransmissionTypes();
    }

    @GetMapping("/{id}")
    public GetTransmissionTypeByIdResponses getTransmissionTypeById(@PathVariable int id){
        return transmissionTypeService.getTransmissionTypeById(id);
    }

    @PutMapping("/{id}")
    public UpdateTransmissionTypeResponses updateTransmissionTypeById(@RequestBody UpdateTransmissionTypeRequests requests,
                                                                      @PathVariable int id){
        return transmissionTypeService.updateTransmissionTypeById(requests,id);
    }

    @DeleteMapping("/{id}")
    void deleteTransmissionTypeById(@PathVariable int id){
        transmissionTypeService.deleteTransmissionTypeById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }
}
