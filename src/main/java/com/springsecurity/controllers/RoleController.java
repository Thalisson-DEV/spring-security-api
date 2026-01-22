package com.springsecurity.controllers;

import com.springsecurity.models.dto.RoleRequestDTO;
import com.springsecurity.services.RoleService;
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
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/roles")
    public ResponseEntity<@NonNull Void> createRole(@RequestBody @Validated RoleRequestDTO roleRequest) {
        this.roleService.createRole(roleRequest);

        return ResponseEntity.ok().build();
    }
}
