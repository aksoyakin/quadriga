package dev.akinaksoy.quadrigabe.services.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllModelResponses {

    private int id;
    private String name;
    private int brandId;
    private LocalDate createdDate;
    private LocalDate updatedDate;
    private String brandName;
}
