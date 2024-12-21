package com.youcode.paroly.mapper;

import com.youcode.paroly.dto.request.UserRequestDTO;
import com.youcode.paroly.dto.response.UserResponseDTO;
import com.youcode.paroly.entity.Role;
import com.youcode.paroly.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "roles", expression = "java(mapRolesToStrings(user.getRoles()))")
    UserResponseDTO toDTO(User user);

    @Mapping(target = "roles", ignore = true)
    User toEntity(UserRequestDTO userRequestDTO);

    default List<String> mapRolesToStrings(List<Role> roles) {
        return roles.stream().map(Role::getName).collect(Collectors.toList());
    }
}
