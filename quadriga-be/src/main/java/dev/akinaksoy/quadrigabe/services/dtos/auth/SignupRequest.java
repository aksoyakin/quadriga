package dev.akinaksoy.quadrigabe.services.dtos.auth;

import lombok.Data;

@Data
public class SignupRequest {
    private String email;

    private String name;

    private String password;
}
