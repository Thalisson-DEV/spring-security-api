package com.springsecurity.models.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AuthenticationRequestDTO(
        @NotBlank
        String username,
        @Size(min = 5, max = 12, message = "A senha deve ter entre 5 a 12 caracteres.")
        String password
) {
}
