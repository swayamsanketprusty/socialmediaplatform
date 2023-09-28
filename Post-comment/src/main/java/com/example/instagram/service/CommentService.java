package com.example.instagram.service;

import com.example.instagram.model.Comment;
import com.example.instagram.repository.CommentRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CommentService {
    @Autowired
    private CommentRepo commentRepo;

    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }
}








