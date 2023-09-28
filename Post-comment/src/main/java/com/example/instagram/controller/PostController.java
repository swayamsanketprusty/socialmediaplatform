package com.example.instagram.controller;

import com.example.instagram.model.Comment;
import com.example.instagram.model.Post;
import com.example.instagram.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/list")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @PutMapping("/{postId}/like")
    public Post likePost(@PathVariable int postId) {
        return postService.likePost(postId);
    }

    @PostMapping("/add")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post savedPost = postService.createPost(post);
        return ResponseEntity.ok(savedPost);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable int postId) {
        Optional<Post> optionalPost = postService.getPost(postId);
        return optionalPost.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<Comment> addCommentToPost(@PathVariable int postId, @RequestBody Comment comment) {
        Optional<Post> optionalPost = postService.getPost(postId);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            comment.setPost(post);
            Comment savedComment = postService.addComment(post, comment);
            return ResponseEntity.ok(savedComment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{postId}/comments")
    public ResponseEntity<List<Comment>> getCommentsForPost(@PathVariable int postId) {
        List<Comment> comments = postService.getCommentsForPost(postId);
        return ResponseEntity.ok(comments);
    }
}

