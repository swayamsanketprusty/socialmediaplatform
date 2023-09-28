package com.lcwd.userService.external;

import com.lcwd.userService.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="POST-SERVICE")
public interface Services {
    @GetMapping("/posts/users/{userId}")
    List<Post> getPostsByUserId (@PathVariable("userId") String userId) ;
}

