package com.springsecurity.controllers;

import com.springsecurity.models.dto.RegisterRequestDTO;
import com.springsecurity.services.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<@NonNull Void> register(@RequestBody @Validated RegisterRequestDTO registerRequest) {
        this.userService.createUser(registerRequest);

        return ResponseEntity.ok().build();
    }

}
