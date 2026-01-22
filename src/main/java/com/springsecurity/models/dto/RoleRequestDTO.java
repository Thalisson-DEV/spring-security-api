package com.springsecurity.models.dto;

import com.springsecurity.models.entity.RoleType;
import jakarta.validation.constraints.NotBlank;

public record RoleRequestDTO(
        @NotBlank(message = "A role não pode estar em branco.")
        RoleType roleType
) {}
