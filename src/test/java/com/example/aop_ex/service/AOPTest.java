package com.example.aop_ex.service;

import com.example.aop_ex.aop.AspectLog;
import com.example.aop_ex.aop.AspectPerformance;
import com.example.aop_ex.controller.PostController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@SpringBootTest
@Import({AspectLog.class, AspectPerformance.class})        // 프록시에 추가
public class AOPTest {

    @Autowired
    PostController postController;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PostRepository postRepository;

    //    수작업으로 프록시 적용
    @Test
    public void testProxyEnabled() {
        log.info("userRepository aopProxy enabled ? {} ", AopUtils.isAopProxy(userRepository));
        log.info("postRepository aopProxy enabled ? {} ", AopUtils.isAopProxy(postRepository));
    }

    @Test
    public void testPostSave() {
//        userRepository.saveUser("userA");
        postController.newPost("userA");
    }

    @Test
    public void testUserSave() {
//        userRepository.saveUser("userA");
        userRepository.saveUser("userA");
    }
}
