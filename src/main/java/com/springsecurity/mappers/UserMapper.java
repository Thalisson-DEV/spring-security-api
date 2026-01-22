package com.springsecurity.mappers;

import com.springsecurity.models.dto.LoginResponseDTO;
import com.springsecurity.models.dto.RegisterRequestDTO;
import com.springsecurity.models.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User dtoToEntity(RegisterRequestDTO dto);

    LoginResponseDTO entityToDto(User user);
}
