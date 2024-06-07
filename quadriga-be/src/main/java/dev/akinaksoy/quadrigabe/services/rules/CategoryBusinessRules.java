package dev.akinaksoy.quadrigabe.services.rules;

import dev.akinaksoy.quadrigabe.dao.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryBusinessRules {

    private final CategoryRepository categoryRepository;

    public void checkIfName(String name) {
        if (this.categoryRepository.existsByName(name)) {
            throw new RuntimeException("You can't use the same category name twice.");
        }
    }
}
