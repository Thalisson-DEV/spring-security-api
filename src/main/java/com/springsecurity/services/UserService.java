package com.springsecurity.services;

import com.springsecurity.exceptions.EntityAlreadyExistsException;
import com.springsecurity.mappers.UserMapper;
import com.springsecurity.models.dto.RegisterRequestDTO;
import com.springsecurity.models.entity.Role;
import com.springsecurity.models.entity.User;
import com.springsecurity.repositories.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Transactional
    public void createUser(@Valid RegisterRequestDTO registerRequest) {
        if(this.userRepository.existsByUsername(registerRequest.username())) {
            throw new EntityAlreadyExistsException("User already exists");
        }

        User user = this.userMapper.dtoToEntity(registerRequest);
        String encryptedPassword = this.passwordEncoder.encode(registerRequest.password());

        user.setPassword(encryptedPassword);
        validateUserRoles(user);

        this.userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User findUserEntityByUsername(String username) {
        return this.userRepository.findUserEntityByUsername(username);
    }

    private void validateUserRoles(User newUser) {
        if (newUser.getRoles() != null && !newUser.getRoles().isEmpty()) {
            Set<Role> managedRoles = newUser.getRoles().stream()
                    .map(role -> this.roleService.findRoleEntityById(role.getId()))
                    .collect(Collectors.toSet());

            newUser.setRoles(managedRoles);
        }
    }
}
