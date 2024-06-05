package dev.akinaksoy.quadrigabe.services.dtos.responses.brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBrandByIdResponses {

    private int id;
    private String name;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
