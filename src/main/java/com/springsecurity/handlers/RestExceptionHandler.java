package com.springsecurity.handlers;

import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.springsecurity.exceptions.EntityAlreadyExistsException;
import com.springsecurity.models.dto.RestExceptionResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(JWTCreationException.class)
    public ResponseEntity<@NonNull RestExceptionResponseDTO> handleJWTCreationException(JWTCreationException e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO(
                LocalDateTime.now(),
                e.getMessage(),
                null,
                status.value()
        );

        return ResponseEntity.internalServerError().body(exceptionResponse);
    }

    @ExceptionHandler(JWTDecodeException.class)
    public ResponseEntity<@NonNull RestExceptionResponseDTO> handleJWTDecodeException(JWTDecodeException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO(
                LocalDateTime.now(),
                e.getMessage(),
                null,
                status.value()
        );

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<@NonNull RestExceptionResponseDTO> handleEntityAlreadyExistsException(EntityAlreadyExistsException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO(
                LocalDateTime.now(),
                e.getMessage(),
                null,
                status.value()
        );

        return ResponseEntity.badRequest().body(exceptionResponse);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<@NonNull RestExceptionResponseDTO> handleEntityNotFoundException(EntityNotFoundException e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;

        RestExceptionResponseDTO exceptionResponse = new RestExceptionResponseDTO(
                LocalDateTime.now(),
                e.getMessage(),
                null,
                status.value()
        );

        return ResponseEntity.badRequest().body(exceptionResponse);
    }
}
