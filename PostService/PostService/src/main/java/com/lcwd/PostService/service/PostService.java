package com.lcwd.PostService.service;

import com.lcwd.PostService.Repo.PostRepository;



import com.lcwd.PostService.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;



    public Post create(Post post){
        String rendomUid = UUID.randomUUID().toString();
        post.setPostId(rendomUid);

        return postRepository.save(post);
    }
    public List<Post> getPost(){
        return postRepository.findAll();
    }
    public  List<Post> getPostUserId(String usedId){

       List<Post> post= postRepository.findByUserId(usedId);



       return  post;
    }

}
