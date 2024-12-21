package com.youcode.paroly.service.Interface;

import com.youcode.paroly.dto.request.UserRequestDTO;
import com.youcode.paroly.dto.response.UserResponseDTO;

public interface AuthService {
    UserResponseDTO login(UserRequestDTO Authrequest);
    UserResponseDTO register(UserRequestDTO Authrequest);
}
