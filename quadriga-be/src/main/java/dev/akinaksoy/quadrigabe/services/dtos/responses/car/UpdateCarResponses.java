package dev.akinaksoy.quadrigabe.services.dtos.responses.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarResponses {

    private int id;
    private boolean isAvailable;
    private int year;
    private int mileageCounter;
    private int seatingCapacity;
    private String plate;
    private String description;
    private double price;
    private int colorId;
    private int categoryId;
    private int modelId;
    private int brandId;
    private int fuelTypeId;
    private int transmissionTypeId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
