package dev.akinaksoy.quadrigabe.services.rules;

import dev.akinaksoy.quadrigabe.dao.ColorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ColorBusinessRules {

    private ColorRepository colorRepository;

    public void checkIfName(String name) {
        if (this.colorRepository.existsByName(name)) {
            throw new RuntimeException("You can't use the same category name twice.");
        }
    }
}
