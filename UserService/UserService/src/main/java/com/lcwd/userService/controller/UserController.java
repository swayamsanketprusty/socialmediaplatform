package com.lcwd.userService.controller;

import com.lcwd.userService.config.UserAuthProvider;
import com.lcwd.userService.model.User;
import com.lcwd.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class  UserController {
    @Autowired
    private UserService userServices;
    @Autowired
    private UserAuthProvider userAuthProvider;

    @PostMapping("/register")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1=userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {
        user = userServices.loginUser(user);
        String token = userAuthProvider.createToken(user);
        return ResponseEntity.created(URI.create("/user/" + user.getUserId())).body(token);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        User user = userServices.getUser(userId);
        return  ResponseEntity.ok(user);
    }

    @GetMapping("/")
    public  ResponseEntity<List<User>> getallUser(){
        List<User> allUser=userServices.getAlluser();
        return ResponseEntity.ok(allUser);
    }

}
