package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.dao.ColorRepository;
import dev.akinaksoy.quadrigabe.entities.concretes.Color;
import dev.akinaksoy.quadrigabe.services.abstracts.ColorService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.color.CreateColorRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.color.UpdateColorRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.CreatedColorResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.GetAllColorResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.GetColorByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.UpdateColorResponses;
import dev.akinaksoy.quadrigabe.services.rules.ColorBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ColorManager implements ColorService {
    
    private final ColorRepository colorRepository;
    private final ModelMapperService modelMapperService;
    private final ColorBusinessRules colorBusinessRules;

    @Override
    public CreatedColorResponses createColor(CreateColorRequests requests) {
        colorBusinessRules.checkIfName(requests.getName());

        Color color = this.modelMapperService.forRequest()
                .map(requests, Color.class);

        color.setId(0);
        colorRepository.save(color);

        CreatedColorResponses responses = this.modelMapperService.forResponse()
                .map(color, CreatedColorResponses.class);

        return responses;
    }

    @Override
    public List<GetAllColorResponses> getAllColors() {
        List<Color> colors = colorRepository.findAll();

        List<GetAllColorResponses> responses = colors.stream()
                .map(color -> modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetColorByIdResponses getColorById(int id) {
        Color color = colorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no color for this id: " + id));

        GetColorByIdResponses response = this.modelMapperService.forResponse()
                .map(color, GetColorByIdResponses.class);

        return response;
    }

    @Override
    public UpdateColorResponses updateColorById(UpdateColorRequests requests, int id) {
        Color color = colorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no color for this id: " + id));

        Color updatedColor = modelMapperService.forRequest()
                .map(requests,Color.class);

        color.setId(id);
        color.setUpdatedDate(LocalDate.now());
        color.setName(updatedColor.getName() != null ? updatedColor.getName() : color.getName());
        colorRepository.save(color);

        UpdateColorResponses response = modelMapperService.forResponse()
                .map(color, UpdateColorResponses.class);

        return response;
    }

    @Override
    public void deleteColorById(int id) {
        Color color = colorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no color for this id: " + id));

        this.colorRepository.delete(color);
    }

    @Override
    public List<GetAllColorResponses> findColorByName(String name) {
        List<Color> colors = colorRepository.findByName(name);
        List<GetAllColorResponses> response = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllColorResponses> findColorByNameStartingWith(String name) {
        List<Color> colors = colorRepository.findByNameStartingWith(name);
        List<GetAllColorResponses> response = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllColorResponses> findColorByNameEndingWith(String name) {
        List<Color> colors = colorRepository.findByNameEndingWith(name);
        List<GetAllColorResponses> response = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllColorResponses> findColorByNameContaining(String name) {
        List<Color> colors = colorRepository.findByNameContaining(name);
        List<GetAllColorResponses> response = colors.stream()
                .map(color -> this.modelMapperService.forResponse()
                        .map(color, GetAllColorResponses.class)).collect(Collectors.toList());

        return response;
    }
}
