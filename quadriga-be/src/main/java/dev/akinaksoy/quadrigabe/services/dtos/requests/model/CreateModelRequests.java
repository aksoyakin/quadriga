package dev.akinaksoy.quadrigabe.services.dtos.requests.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateModelRequests {

    private String name;
    private int brandId;
}
