package com.youcode.paroly.mapper;

import com.youcode.paroly.dto.RoleDTO;
import com.youcode.paroly.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDTO(Role role);

    Role toEntity(RoleDTO roleDTO);
}
