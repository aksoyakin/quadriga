package dev.akinaksoy.quadrigabe.services.dtos.responses.color;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllColorResponses {

    private int id;
    private String name;
    private LocalDate createdDate;
    private LocalDate updatedDate;
}
