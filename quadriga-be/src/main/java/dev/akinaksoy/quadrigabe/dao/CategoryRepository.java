package dev.akinaksoy.quadrigabe.dao;

import dev.akinaksoy.quadrigabe.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

    boolean existsByName(String name);
    List<Category> findByName(String name);
    List<Category> findByNameContaining(String name);
    List<Category> findByNameStartingWith(String name);
    List<Category> findByNameEndingWith(String name);
}
