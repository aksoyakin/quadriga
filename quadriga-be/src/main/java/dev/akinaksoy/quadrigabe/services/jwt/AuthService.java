package dev.akinaksoy.quadrigabe.services.jwt;

import dev.akinaksoy.quadrigabe.services.dtos.auth.SignupRequest;
import dev.akinaksoy.quadrigabe.services.dtos.auth.UserDto;

public interface AuthService {

    UserDto createCustomer(SignupRequest signupRequest);

    boolean hasCustomerWithEmail(String email);
}
