package com.lcwd.commentService.service;

import com.lcwd.commentService.model.Comment;
import com.lcwd.commentService.repo.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment create(Comment comment){
        String rendomUid = UUID.randomUUID().toString();
        comment.setCommentId(rendomUid);

        return commentRepository.save(comment);
    }
    public List<Comment> getComment(){
        return commentRepository.findAll();
    }
    public  List<Comment> getCommentPostId(String postId){
        return commentRepository.findByPostId(postId);
    }

}
