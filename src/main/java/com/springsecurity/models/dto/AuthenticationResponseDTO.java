package com.springsecurity.models.dto;

public record AuthenticationResponseDTO(
        String token,
        LoginResponseDTO user
) {
}
