package com.lcwd.PostService.controller;

import com.lcwd.PostService.model.Post;
import com.lcwd.PostService.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    public PostService postService;

    @PostMapping
    public ResponseEntity<Post> create(@RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.create(post));
    }
    @GetMapping
    public ResponseEntity<List<Post>> getPosts(){
        return  ResponseEntity.ok(postService.getPost());
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Post>> getPostsByUserId(@PathVariable String userId){
        return  ResponseEntity.ok(postService.getPostUserId(userId));
    }



}
