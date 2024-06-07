package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.CategoryService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.category.CreateCategoryRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.category.UpdateCategoryRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.CreatedCategoryResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.GetAllCategoryResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.GetCategoryByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.category.UpdateCategoryResponses;
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
@RequestMapping("api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    
    private final CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCategoryResponses createCategory(@Valid @RequestBody CreateCategoryRequests requests){
        return categoryService.createCategory(requests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllCategoryResponses> getAllCategorys() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public GetCategoryByIdResponses getCategoryById(@PathVariable int id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping("/{id}")
    public UpdateCategoryResponses updateCategoryById(@RequestBody UpdateCategoryRequests requests,
                                                @PathVariable int id){
        return categoryService.updateCategoryById(requests,id);
    }
    @DeleteMapping("/{id}")
    void deleteCategoryById(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }

    @GetMapping("/findByName")
    public List<GetAllCategoryResponses> findCategoryByName(String name){
        return categoryService.findCategoryByName(name);
    }

    @GetMapping("/findByNameStartingWith")
    public List<GetAllCategoryResponses> findByNameStartingWith(String name) {
        return this.categoryService.findCategoryByNameStartingWith(name);
    }

    @GetMapping("/findByNameEndingWith")
    public List<GetAllCategoryResponses> findByNameEndingWith(String name) {
        return this.categoryService.findCategoryByNameEndingWith(name);
    }

    @GetMapping("/findByNameContaining")
    public List<GetAllCategoryResponses> findByNameContaining(String name) {
        return this.categoryService.findCategoryByNameContaining(name);
    }
}
