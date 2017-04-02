package com.sang.topic.web.rest;

import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.CommentService;
import com.sang.topic.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/rest/c")
public class CommentRestController {
    @Autowired
    CommentService commentService;

    @PostMapping("")
    public Result add(HttpServletRequest request, Integer postId, String content) throws ResultException {
        Comment comment = commentService.add(content, postId, SessionUtil.getUser(request));
        return Result.success().add("comment", comment);
    }
}
