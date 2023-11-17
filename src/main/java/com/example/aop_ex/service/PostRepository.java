package com.example.aop_ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
public class PostRepository {
    public void savePost(String post) {
        log.info("savePost ==> " + post);
    }
}
