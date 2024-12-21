package com.youcode.paroly.service.Interface;

import com.youcode.paroly.dto.request.UserRequestDTO;
import com.youcode.paroly.dto.response.UserResponseDTO;
import com.youcode.paroly.entity.User;

import java.util.List;

public interface UserService {
    UserResponseDTO register(UserRequestDTO userDTO);
    List<UserResponseDTO> getAllUsers();
    void updateUserRoles(String id, List<String> roles);
    User loadUserByUsername(String username);
}
