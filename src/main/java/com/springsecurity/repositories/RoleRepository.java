package com.springsecurity.repositories;

import com.springsecurity.models.entity.Role;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<@NonNull Role, @NonNull Long> {
}
