package com.example.aop_ex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PostController {
    @Autowired
    PostRepository postRepository;

    public void newPost(String title) {
        postRepository.savePost("hello , " + title);

    }
}
