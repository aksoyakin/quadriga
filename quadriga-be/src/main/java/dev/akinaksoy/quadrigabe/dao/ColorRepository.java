package dev.akinaksoy.quadrigabe.dao;

import dev.akinaksoy.quadrigabe.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ColorRepository extends JpaRepository<Color, Integer> {

    boolean existsByName(String name);
    List<Color> findByName(String name);
    List<Color> findByNameContaining(String name);
    List<Color> findByNameStartingWith(String name);
    List<Color> findByNameEndingWith(String name);
}
