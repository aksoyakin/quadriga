package dev.akinaksoy.quadrigabe.controllers;

import dev.akinaksoy.quadrigabe.services.abstracts.BrandService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.brand.CreateBrandRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.brand.UpdateBrandRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.CreatedBrandResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.GetAllBrandResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.GetBrandByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.UpdateBrandResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BrandController class.
 */

@CrossOrigin
@RestController
@RequestMapping("api/v1/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedBrandResponses createBrand(@Valid @RequestBody CreateBrandRequests requests){
        return brandService.createBrand(requests);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<GetAllBrandResponses> getAllBrands() {
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public GetBrandByIdResponses getBrandById(@PathVariable int id){
        return brandService.getBrandById(id);
    }

    @PutMapping("/{id}")
    public UpdateBrandResponses updateBrandById(@RequestBody UpdateBrandRequests requests,
                                                @PathVariable int id){
        return brandService.updateBrandById(requests,id);
    }
    @DeleteMapping("/{id}")
    void deleteBrandById(@PathVariable int id){
        brandService.deleteBrandById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
    }

    @GetMapping("/findByName")
    public List<GetAllBrandResponses> findBrandByName(String name){
        return brandService.findBrandByName(name);
    }

    @GetMapping("/findByNameStartingWith")
    public List<GetAllBrandResponses> findByNameStartingWith(String name) {
        return this.brandService.findBrandByNameStartingWith(name);
    }

    @GetMapping("/findByNameEndingWith")
    public List<GetAllBrandResponses> findByNameEndingWith(String name) {
        return this.brandService.findBrandByNameEndingWith(name);
    }

    @GetMapping("/findByNameContaining")
    public List<GetAllBrandResponses> findByNameContaining(String name) {
        return this.brandService.findBrandByNameContaining(name);
    }
}
