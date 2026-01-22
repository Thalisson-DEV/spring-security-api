package com.springsecurity.models.dto;

import com.springsecurity.models.entity.Role;

import java.util.Set;

public record LoginResponseDTO(
        String id,
        String firstName,
        String lastName,
        String username,
        String email,
        String password,
        Set<Role> roles
) {
}
