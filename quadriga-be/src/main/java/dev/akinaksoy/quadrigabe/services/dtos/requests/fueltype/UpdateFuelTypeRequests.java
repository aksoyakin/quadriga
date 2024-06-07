package dev.akinaksoy.quadrigabe.services.dtos.requests.fueltype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFuelTypeRequests {

    private int id;
    private String type;
}
