package dev.akinaksoy.quadrigabe.services.dtos.requests.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBrandRequests {

    private int id;
    private String name;
}
