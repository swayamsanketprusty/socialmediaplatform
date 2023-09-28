package com.lcwd.userService.service;

import com.lcwd.userService.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAlluser();

    User getUser(String userId);
    User loginUser(User user);
}