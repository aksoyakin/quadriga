package dev.akinaksoy.quadrigabe.services.dtos.requests.car;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRequests {

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
    private int fuelTypeId;
    private int transmissionTypeId;
}
