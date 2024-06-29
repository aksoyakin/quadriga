package dev.akinaksoy.quadrigabe.services.dtos.auth;

import dev.akinaksoy.quadrigabe.entities.concretes.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;
}
