package com.sang.topic.controller;

import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.CommentService;
import com.sang.topic.util.SessionUtil;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/c")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("")
    public Result add(HttpServletRequest request, Integer postId, String content) {
        try {
            Comment comment = commentService.add(content, postId, SessionUtil.getUser(request));
            return Result.success().add("comment", comment);
        } catch (Exception e) {
            return Result.exception(e);
        }
    }
}
