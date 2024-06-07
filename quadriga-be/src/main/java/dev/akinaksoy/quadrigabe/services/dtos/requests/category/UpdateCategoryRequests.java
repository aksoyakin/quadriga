package dev.akinaksoy.quadrigabe.services.dtos.requests.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequests {

    private int id;
    private String name;
}
