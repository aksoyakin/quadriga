package dev.akinaksoy.quadrigabe.services.dtos.auth;

import dev.akinaksoy.quadrigabe.entities.concretes.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {
    private String jwt;
    private UserRole userRole;
    private Long userId;
}
