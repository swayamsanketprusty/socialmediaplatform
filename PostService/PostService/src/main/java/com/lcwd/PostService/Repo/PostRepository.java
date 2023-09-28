package com.lcwd.PostService.Repo;

import com.lcwd.PostService.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,String> {
    List<Post> findByUserId(String userId);

}
