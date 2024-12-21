package com.youcode.paroly.service.impl;

import com.youcode.paroly.dto.request.UserRequestDTO;
import com.youcode.paroly.dto.response.UserResponseDTO;
import com.youcode.paroly.entity.Role;
import com.youcode.paroly.entity.User;
import com.youcode.paroly.exception.ResourceNotFoundException;
import com.youcode.paroly.mapper.UserMapper;
import com.youcode.paroly.repository.RoleRepository;
import com.youcode.paroly.repository.UserRepository;
import com.youcode.paroly.service.Interface.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;
    private UserMapper userMapper;

    @Override
    public UserResponseDTO register(UserRequestDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        List<Role> roles = userDTO.getRoles().stream()
                .map(roleName -> roleRepository.findByName(roleName))
                .collect(Collectors.toList());

        if (roles.isEmpty()) {
            roles.add(roleRepository.findByName("USER"));
        }

        user.setRoles(roles);

        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public void updateUserRoles(String id, List<String> roles) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        List<Role> updatedRoles = roles.stream().map(roleRepository::findByName).collect(Collectors.toList());
        user.setRoles(updatedRoles);
        userRepository.save(user);
    }

    @Override
    public User loadUserByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + username));
    }
}
