package com.sang.topic.admin.rest;

import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.CommentService;
import com.sang.topic.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/admin/rest/c")
public class CommentAdminRestController {
    @Autowired
    CommentService commentService;
}
