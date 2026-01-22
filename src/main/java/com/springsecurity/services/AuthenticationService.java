package com.springsecurity.services;

import com.springsecurity.infra.security.TokenService;
import com.springsecurity.mappers.UserMapper;
import com.springsecurity.models.dto.AuthenticationRequestDTO;
import com.springsecurity.models.dto.AuthenticationResponseDTO;
import com.springsecurity.models.dto.LoginResponseDTO;
import com.springsecurity.models.entity.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;
    private final UserMapper userMapper;

    public AuthenticationResponseDTO login(@Valid AuthenticationRequestDTO authenticationRequest) {
        UsernamePasswordAuthenticationToken usernamePassword = new UsernamePasswordAuthenticationToken(authenticationRequest.username(), authenticationRequest.password());
        Authentication auth = this.authenticationManager.authenticate(usernamePassword);

        String token = tokenService.generateToken((User) Objects.requireNonNull(auth.getPrincipal()));

        return new AuthenticationResponseDTO(token, this.userMapper.entityToDto((User) auth.getPrincipal()));
    }

}
