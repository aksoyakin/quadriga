package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.dao.CategoryRepository;
import dev.akinaksoy.quadrigabe.entities.concretes.Category;
import dev.akinaksoy.quadrigabe.services.abstracts.CategoryService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.category.CreateCategoryRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.category.UpdateCategoryRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.CreatedCategoryResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.GetAllCategoryResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.GetCategoryByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.UpdateCategoryResponses;
import dev.akinaksoy.quadrigabe.services.rules.CategoryBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryManager implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapperService modelMapperService;
    private final CategoryBusinessRules categoryBusinessRules;

    @Override
    public CreatedCategoryResponses createCategory(CreateCategoryRequests requests) {
        categoryBusinessRules.checkIfName(requests.getName());

        Category category = this.modelMapperService.forRequest()
                .map(requests, Category.class);

        category.setId(0);
        categoryRepository.save(category);

        CreatedCategoryResponses responses = this.modelMapperService.forResponse()
                .map(category, CreatedCategoryResponses.class);

        return responses;
    }

    @Override
    public List<GetAllCategoryResponses> getAllCategories() {
        List<Category> categorys = categoryRepository.findAll();

        List<GetAllCategoryResponses> responses = categorys.stream()
                .map(category -> modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetCategoryByIdResponses getCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no category for this id: " + id));

        GetCategoryByIdResponses response = this.modelMapperService.forResponse()
                .map(category, GetCategoryByIdResponses.class);

        return response;
    }

    @Override
    public UpdateCategoryResponses updateCategoryById(UpdateCategoryRequests requests, int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no category for this id: " + id));

        Category updatedCategory = modelMapperService.forRequest()
                .map(requests,Category.class);

        category.setId(id);
        category.setUpdatedDate(LocalDate.now());
        category.setName(updatedCategory.getName() != null ? updatedCategory.getName() : category.getName());
        categoryRepository.save(category);

        UpdateCategoryResponses response = modelMapperService.forResponse()
                .map(category, UpdateCategoryResponses.class);

        return response;
    }

    @Override
    public void deleteCategoryById(int id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no category for this id: " + id));

        this.categoryRepository.delete(category);
    }

    @Override
    public List<GetAllCategoryResponses> findCategoryByName(String name) {
        List<Category> categorys = categoryRepository.findByName(name);
        List<GetAllCategoryResponses> response = categorys.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllCategoryResponses> findCategoryByNameStartingWith(String name) {
        List<Category> categorys = categoryRepository.findByNameStartingWith(name);
        List<GetAllCategoryResponses> response = categorys.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllCategoryResponses> findCategoryByNameEndingWith(String name) {
        List<Category> categorys = categoryRepository.findByNameEndingWith(name);
        List<GetAllCategoryResponses> response = categorys.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllCategoryResponses> findCategoryByNameContaining(String name) {
        List<Category> categorys = categoryRepository.findByNameContaining(name);
        List<GetAllCategoryResponses> response = categorys.stream()
                .map(category -> this.modelMapperService.forResponse()
                        .map(category, GetAllCategoryResponses.class)).collect(Collectors.toList());

        return response;
    }
}
