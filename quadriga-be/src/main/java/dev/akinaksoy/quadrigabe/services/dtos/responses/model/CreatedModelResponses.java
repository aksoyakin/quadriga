package dev.akinaksoy.quadrigabe.services.dtos.responses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedModelResponses {

    private int id;
    private String name;
    private int brandId;
    private LocalDate createdDate;
}
