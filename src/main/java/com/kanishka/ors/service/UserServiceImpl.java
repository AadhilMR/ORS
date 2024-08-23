package com.kanishka.ors.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kanishka.ors.dto.UserDTO;
import com.kanishka.ors.entity.User;
import com.kanishka.ors.entity.UserType;
import com.kanishka.ors.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean register(UserDTO userDTO) {
        Optional<User> userByMobile = userRepository.findByMobile(userDTO.getMobile());

        if(userByMobile.isPresent()) {
            return false;
        }

        User user = new User();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setMobile(userDTO.getMobile());
        user.setPassword(userDTO.getPassword());
        user.setUserType(UserType.valueOf(userDTO.getUserType()));

        return userRepository.save(user) != null;
    }

    @Override
    public User login(String mobile, String password) {
        Optional<User> userByCredentials = userRepository.findByMobileAndPassword(mobile, password);

        if(userByCredentials.isPresent()) {
            return userByCredentials.get();
        }
        return null;
    }
}
