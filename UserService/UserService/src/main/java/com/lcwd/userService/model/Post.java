package com.lcwd.userService.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private String userId;
    private String postId;

    private String Image;
    private String description;

    private List<Comment> comment=new ArrayList<>();
}
