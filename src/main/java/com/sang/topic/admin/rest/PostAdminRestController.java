package com.sang.topic.admin.rest;

import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.CommentService;
import com.sang.topic.service.PostService;
import com.sang.topic.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/admin/rest/p")
public class PostAdminRestController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;
}
