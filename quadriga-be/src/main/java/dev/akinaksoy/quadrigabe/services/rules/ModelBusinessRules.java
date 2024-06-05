package dev.akinaksoy.quadrigabe.services.rules;

import dev.akinaksoy.quadrigabe.dao.ModelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

    private ModelRepository modelRepository;

    public void checkIfName(String name) {
        if(this.modelRepository.existsByName(name)){
            throw new RuntimeException("You can't use the same model name twice.");
        }
    }
}
