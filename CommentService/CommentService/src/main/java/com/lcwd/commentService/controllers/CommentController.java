package com.lcwd.commentService.controllers;

import com.lcwd.commentService.model.Comment;
import com.lcwd.commentService.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    public CommentService commentService;
    @PostMapping
    public ResponseEntity<Comment> create(@RequestBody Comment comment){
        return ResponseEntity.status(HttpStatus.CREATED).body(commentService.create(comment));
    }
    @GetMapping
    public ResponseEntity<List<Comment>> getComments(){
        return  ResponseEntity.ok(commentService.getComment());
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<List<Comment>> getCommentsByPostId(@PathVariable String postId){
        return  ResponseEntity.ok(commentService.getCommentPostId(postId));
    }
}
