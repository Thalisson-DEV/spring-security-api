package com.springsecurity.mappers;

import com.springsecurity.models.dto.RoleRequestDTO;
import com.springsecurity.models.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "id", ignore = true)
    Role dtoToEntity(RoleRequestDTO roleRequestDTO);
}
