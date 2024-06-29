package dev.akinaksoy.quadrigabe.services.dtos.auth;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String email;
    private String password;
}
