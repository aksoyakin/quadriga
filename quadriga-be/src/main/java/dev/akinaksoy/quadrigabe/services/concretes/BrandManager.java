package dev.akinaksoy.quadrigabe.services.concretes;

import dev.akinaksoy.quadrigabe.core.utilities.modelmapper.ModelMapperService;
import dev.akinaksoy.quadrigabe.dao.BrandRepository;
import dev.akinaksoy.quadrigabe.entities.concretes.Brand;
import dev.akinaksoy.quadrigabe.services.abstracts.BrandService;
import dev.akinaksoy.quadrigabe.services.dtos.requests.brand.CreateBrandRequests;
import dev.akinaksoy.quadrigabe.services.dtos.requests.brand.UpdateBrandRequests;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.CreatedBrandResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.GetAllBrandResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.GetBrandByIdResponses;
import dev.akinaksoy.quadrigabe.services.dtos.responses.brand.UpdateBrandResponses;
import dev.akinaksoy.quadrigabe.services.rules.BrandBusinessRules;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;
    private final BrandBusinessRules brandBusinessRules;

    @Override
    public CreatedBrandResponses createBrand(CreateBrandRequests requests) {
        brandBusinessRules.checkName(requests.getName());

        Brand brand = this.modelMapperService.forRequest()
                .map(requests, Brand.class);

        brand.setId(0);
        brandRepository.save(brand);

        CreatedBrandResponses responses = this.modelMapperService.forResponse()
                .map(brand, CreatedBrandResponses.class);

        return responses;
    }

    @Override
    public List<GetAllBrandResponses> getAllBrands() {
        List<Brand> brands = brandRepository.findAll();

        List<GetAllBrandResponses> responses = brands.stream()
                .map(brand -> modelMapperService.forResponse()
                .map(brand, GetAllBrandResponses.class))
                .collect(Collectors.toList());

        return responses;
    }

    @Override
    public GetBrandByIdResponses getBrandById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this id: " + id));

        GetBrandByIdResponses response = this.modelMapperService.forResponse()
                .map(brand, GetBrandByIdResponses.class);

        return response;
    }

    @Override
    public UpdateBrandResponses updateBrandById(UpdateBrandRequests requests, int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this id: " + id));

        Brand updatedBrand = modelMapperService.forRequest()
                .map(requests,Brand.class);

        brand.setId(id);
        brand.setUpdatedDate(LocalDate.now());
        brand.setName(updatedBrand.getName() != null ? updatedBrand.getName() : brand.getName());
        brandRepository.save(brand);

        UpdateBrandResponses response = modelMapperService.forResponse()
                .map(brand, UpdateBrandResponses.class);

        return response;
    }

    @Override
    public void deleteBrandById(int id) {
        Brand brand = brandRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no brand for this id: " + id));

        this.brandRepository.delete(brand);
    }

    @Override
    public List<GetAllBrandResponses> findBrandByName(String name) {
        List<Brand> brands = brandRepository.findByName(name);
        List<GetAllBrandResponses> response = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllBrandResponses> findBrandByNameStartingWith(String name) {
        List<Brand> brands = brandRepository.findByNameStartingWith(name);
        List<GetAllBrandResponses> response = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllBrandResponses> findBrandByNameEndingWith(String name) {
        List<Brand> brands = brandRepository.findByNameEndingWith(name);
        List<GetAllBrandResponses> response = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandResponses.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public List<GetAllBrandResponses> findBrandByNameContaining(String name) {
        List<Brand> brands = brandRepository.findByNameContaining(name);
        List<GetAllBrandResponses> response = brands.stream()
                .map(brand -> this.modelMapperService.forResponse()
                .map(brand, GetAllBrandResponses.class)).collect(Collectors.toList());

        return response;
    }
}
