package com.example.instagram.service;

import com.example.instagram.model.Comment;
import com.example.instagram.model.Post;
import com.example.instagram.repository.CommentRepo;
import com.example.instagram.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    public Post likePost(int postId) {
        Post post = postRepo.findById(postId).orElse(null);
        if (post != null) {
            post.setLikes(post.getLikes() + 1);
            return postRepo.save(post);
        }
        return null;
    }

    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    public Optional<Post> getPost(int postId) {
        return postRepo.findById(postId);
    }

    public Comment addComment(Post post, Comment comment) {
        comment.setPost(post);
        return commentRepo.save(comment);
    }

    public List<Comment> getCommentsForPost(int postId) {
        Optional<Post> optionalPost = postRepo.findById(postId);

            if (optionalPost.isPresent()) {
                Post post = optionalPost.get();
                return post.getComments();
            } else {
                return Collections.emptyList();
            }
    }
}

