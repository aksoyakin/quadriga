package dev.akinaksoy.quadrigabe.dao;

import dev.akinaksoy.quadrigabe.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    boolean existsByPlate(String plate);

    List<Car> findByYear(int year);

    List<Car> findByPlate(String plate);

    List<Car> findByMileageCounter(int mileageCounter);

    List<Car> findByPrice(double price);

    List<Car> findByTransmissionTypeId(int transmissionTypeId);

    List<Car> findByCategoryId(int categoryId);

    List<Car> findByColorId(int colorId);

    List<Car> findByFuelTypeId(int fuelTypeId);

}
