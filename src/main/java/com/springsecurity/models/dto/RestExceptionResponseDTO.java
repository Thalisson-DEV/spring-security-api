package com.springsecurity.models.dto;

import java.time.LocalDateTime;

public record RestExceptionResponseDTO(
        LocalDateTime timestamp,
        String message,
        String instance,
        int status
) {}
