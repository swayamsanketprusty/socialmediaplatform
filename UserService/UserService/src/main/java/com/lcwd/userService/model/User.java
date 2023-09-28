package com.lcwd.userService.model;

import jakarta.persistence.*;
import lombok.*;


import java.util.ArrayList;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="micro_users")
public class User {
    @Id
    private  String userId;
    @Column(length = 20)
    private  String name;
    private String username;
    private String password;
    @Transient
    private List<Post> posts=new ArrayList<>();


}
