package dev.akinaksoy.quadrigabe.services.rules;

import dev.akinaksoy.quadrigabe.dao.BrandRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

    private final BrandRepository brandRepository;

    public void checkName(String name){
        if(this.brandRepository.existsByName(name)){
            throw new RuntimeException("You can't use the same brand name twice.");
        }
    }
}
