package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.category.CreateCategoryRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.category.UpdateCategoryRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.CreatedCategoryResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.GetAllCategoryResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.GetCategoryByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.UpdateCategoryResponses;

import java.util.List;

public interface CategoryService {

    CreatedCategoryResponses createCategory(CreateCategoryRequests requests);
    List<GetAllCategoryResponses> getAllCategories();
    GetCategoryByIdResponses getCategoryById(int id);
    UpdateCategoryResponses updateCategoryById(UpdateCategoryRequests requests, int id);
    void deleteCategoryById(int id);
    List<GetAllCategoryResponses> findCategoryByName(String name);
    List<GetAllCategoryResponses> findCategoryByNameStartingWith(String name);
    List<GetAllCategoryResponses> findCategoryByNameEndingWith(String name);
    List<GetAllCategoryResponses> findCategoryByNameContaining(String name);
}
