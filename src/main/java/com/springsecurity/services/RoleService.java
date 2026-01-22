package com.springsecurity.services;

import com.springsecurity.mappers.RoleMapper;
import com.springsecurity.models.dto.RoleRequestDTO;
import com.springsecurity.models.entity.Role;
import com.springsecurity.repositories.RoleRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Transactional(readOnly = true)
    public Role findRoleEntityById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role not found with id: " + id));
    }

    @Transactional
    public void createRole(@Valid RoleRequestDTO roleRequest) {
        Role role = this.roleMapper.dtoToEntity(roleRequest);
        this.roleRepository.save(role);
    }
}
