package com.lcwd.userService.service.impl;

import com.lcwd.userService.exception.IncorrectPasswordException;
import com.lcwd.userService.exception.ResourceNotFoundException;
import com.lcwd.userService.external.CommentService;
import com.lcwd.userService.external.Services;
import com.lcwd.userService.model.Comment;
import com.lcwd.userService.model.Post;
import com.lcwd.userService.model.User;
import com.lcwd.userService.repository.UserRepository;
import com.lcwd.userService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Services services;

    @Autowired
    private CommentService commentService;

    @Override
    public User saveUser(User user) {

        //genetare unique id
        String rendomUid = UUID.randomUUID().toString();
        user.setUserId(rendomUid);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAlluser() {
        List<User>  users=userRepository.findAll();
        List<User> users1=users.stream().map(user -> {
            List<Post> post = services.getPostsByUserId(user.getUserId());
            List<Post> postList = post.stream().map(p -> {
                List<Comment> comments = commentService.getCommentsByPostId(p.getPostId());
                p.setComment(comments);
                return p;
            }).collect(Collectors.toList());

            user.setPosts(postList);
            return user;
        }).collect(Collectors.toList());

        return users1;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user with given id is not found " + userId));
        List<Post> post = services.getPostsByUserId(user.getUserId());
        List<Post> postList = post.stream().map(p -> {
            List<Comment> comments = commentService.getCommentsByPostId(p.getPostId());
            p.setComment(comments);
            return p;
        }).collect(Collectors.toList());

        user.setPosts(postList);
        return user;
    }
    @Override
    public User loginUser(User user) {
        User verifyUser = userRepository.findByUsername(user.getUsername());

        if(verifyUser == null) {
            throw new ResourceNotFoundException("User Not Found");
        }

        if(!verifyUser.getPassword().equals(user.getPassword())) {
            throw new IncorrectPasswordException("Password Not Matching");
        }

        return verifyUser;
    }
}
