package dev.akinaksoy.quadrigabe.services.abstracts;

import dev.akinaksoy.quadrigabe.services.dtos.requests.brand.CreateBrandRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.brand.UpdateBrandRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.CreatedBrandResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.GetAllBrandResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.GetBrandByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.UpdateBrandResponses;

import java.util.List;

public interface BrandService {

    CreatedBrandResponses createBrand(CreateBrandRequests requests);
    List<GetAllBrandResponses> getAllBrands();
    GetBrandByIdResponses getBrandById(int id);
    UpdateBrandResponses updateBrandById(UpdateBrandRequests requests, int id);
    void deleteBrandById(int id);
    List<GetAllBrandResponses> findBrandByName(String name);
    List<GetAllBrandResponses> findBrandByNameStartingWith(String name);
    List<GetAllBrandResponses> findBrandByNameEndingWith(String name);
    List<GetAllBrandResponses> findBrandByNameContaining(String name);

}
