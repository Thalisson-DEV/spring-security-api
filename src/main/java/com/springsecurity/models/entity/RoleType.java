package com.springsecurity.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RoleType {
    BASIC("basic"),
    ADMIN("admin");

    final String role;
}
