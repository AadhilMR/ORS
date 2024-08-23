package com.kanishka.ors.service;

import com.kanishka.ors.dto.UserDTO;
import com.kanishka.ors.entity.User;

public interface UserService {
    boolean register(UserDTO userDTO);
    User login(String mobile, String password);
}
