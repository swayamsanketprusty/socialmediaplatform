package com.lcwd.userService.external;

import com.lcwd.userService.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COMMENT-SERVICE")
public interface CommentService {
    @GetMapping("/comments/posts/{postId}")
   List<Comment> getCommentsByPostId(@PathVariable String postId);

}
