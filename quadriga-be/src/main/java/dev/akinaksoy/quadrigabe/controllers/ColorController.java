package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.ColorService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.color.CreateColorRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.color.UpdateColorRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.CreatedColorResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.GetAllColorResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.GetColorByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.UpdateColorResponses;
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
@RequestMapping("api/v1/colors")
@RequiredArgsConstructor
public class ColorController {
    
    private final ColorService colorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedColorResponses createColor(@Valid @RequestBody CreateColorRequests requests){
        return colorService.createColor(requests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllColorResponses> getAllColors() {
        return colorService.getAllColors();
    }

    @GetMapping("/{id}")
    public GetColorByIdResponses getColorById(@PathVariable int id){
        return colorService.getColorById(id);
    }

    @PutMapping("/{id}")
    public UpdateColorResponses updateColorById(@RequestBody UpdateColorRequests requests,
                                                @PathVariable int id){
        return colorService.updateColorById(requests,id);
    }
    @DeleteMapping("/{id}")
    void deleteColorById(@PathVariable int id){
        colorService.deleteColorById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }

    @GetMapping("/findByName")
    public List<GetAllColorResponses> findColorByName(String name){
        return colorService.findColorByName(name);
    }

    @GetMapping("/findByNameStartingWith")
    public List<GetAllColorResponses> findByNameStartingWith(String name) {
        return this.colorService.findColorByNameStartingWith(name);
    }

    @GetMapping("/findByNameEndingWith")
    public List<GetAllColorResponses> findByNameEndingWith(String name) {
        return this.colorService.findColorByNameEndingWith(name);
    }

    @GetMapping("/findByNameContaining")
    public List<GetAllColorResponses> findByNameContaining(String name) {
        return this.colorService.findColorByNameContaining(name);
    }
}
