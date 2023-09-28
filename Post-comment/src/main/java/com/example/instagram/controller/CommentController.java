package com.example.instagram.controller;

import com.example.instagram.model.Comment;
import com.example.instagram.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add/{id}")
    public Comment createComment(@PathVariable int id, @RequestBody Comment comment) {
        return commentService.createComment(comment);
    }

    @GetMapping("/List/{id}")
    public List<Comment> getAllComments(@PathVariable int id) {
        return commentService.getAllComments();
    }
    

}

