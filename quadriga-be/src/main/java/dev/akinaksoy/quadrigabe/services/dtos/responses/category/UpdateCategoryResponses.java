package dev.akinaksoy.quadrigabe.services.dtos.responses.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryResponses {

    private int id;
    private String name;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
