package com.springsecurity.models.dto;

import com.springsecurity.models.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Set;

public record RegisterRequestDTO(
        @NotBlank(message = "O primeiro nome não pode estar em branco.")
        String firstName,
        @NotBlank(message = "O ultimo nome não pode estar em branco.")
        String lastName,
        @NotBlank(message = "O username não pode estar em branco.")
        String username,
        @NotBlank(message = "O email não pode estar em branco.")
        @Email(message = "O email é invalido.")
        String email,
        @NotBlank(message = "A senha não pode estar em branco.")
        @Size(min = 5, max = 12, message = "A senha deve ter entre 5 a 12 caracteres.")
        String password,
        @NotBlank(message = "As roles não podem estar em branco.")
        Set<Role> roles
) {
}
