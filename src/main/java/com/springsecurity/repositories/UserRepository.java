package com.springsecurity.repositories;

import com.springsecurity.models.entity.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<@NonNull User, @NonNull String> {
    UserDetails findByUsername(@NonNull String username);

    boolean existsByUsername(String username);

    User findUserEntityByUsername(String username);
}
