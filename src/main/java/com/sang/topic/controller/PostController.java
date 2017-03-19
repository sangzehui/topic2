package com.sang.topic.controller;

import com.sang.topic.common.model.Result;
import com.sang.topic.util.SessionUtil;
import com.sang.topic.service.PostService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/p")
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("")
    public Result add(HttpServletRequest request, String title, String content, Integer topicId) {
        try {
            return postService.add(title, content, topicId, SessionUtil.getUser(request));
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
