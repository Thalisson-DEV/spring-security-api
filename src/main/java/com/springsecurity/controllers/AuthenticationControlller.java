package com.springsecurity.controllers;

import com.springsecurity.models.dto.AuthenticationRequestDTO;
import com.springsecurity.models.dto.AuthenticationResponseDTO;
import com.springsecurity.services.AuthenticationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AuthenticationControlller {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<@NonNull AuthenticationResponseDTO> login(@RequestBody AuthenticationRequestDTO authenticationRequest) {
        AuthenticationResponseDTO authenticationResponse = this.authenticationService.login(authenticationRequest);

        return ResponseEntity.ok().body(authenticationResponse);
    }
}
