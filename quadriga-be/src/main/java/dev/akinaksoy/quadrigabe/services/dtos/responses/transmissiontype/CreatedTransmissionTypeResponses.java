package dev.akinaksoy.quadrigabe.services.dtos.responses.transmissiontype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatedTransmissionTypeResponses {

    private int id;
    private String type;
    private LocalDate createdDate;
}
