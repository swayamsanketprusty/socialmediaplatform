package com.lcwd.userService.repository;

import com.lcwd.userService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User,String> {
    public User findByUsername(String username);
}
