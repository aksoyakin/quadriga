package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.color.CreateColorRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.color.UpdateColorRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.CreatedColorResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.GetAllColorResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.GetColorByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.color.UpdateColorResponses;

import java.util.List;

public interface ColorService {

    CreatedColorResponses createColor(CreateColorRequests requests);
    List<GetAllColorResponses> getAllColors();
    GetColorByIdResponses getColorById(int id);
    UpdateColorResponses updateColorById(UpdateColorRequests requests, int id);
    void deleteColorById(int id);
    List<GetAllColorResponses> findColorByName(String name);
    List<GetAllColorResponses> findColorByNameStartingWith(String name);
    List<GetAllColorResponses> findColorByNameEndingWith(String name);
    List<GetAllColorResponses> findColorByNameContaining(String name);
}
