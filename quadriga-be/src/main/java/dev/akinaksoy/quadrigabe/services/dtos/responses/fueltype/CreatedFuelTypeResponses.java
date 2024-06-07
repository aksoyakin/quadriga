package dev.akinaksoy.quadrigabe.services.dtos.responses.fueltype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedFuelTypeResponses {

    private int id;
    private String type;
    private LocalDate createdDate;
}
