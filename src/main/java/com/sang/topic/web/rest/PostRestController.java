package com.sang.topic.web.rest;

import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.CommentService;
import com.sang.topic.util.SessionUtil;
import com.sang.topic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/rest/p")
public class PostRestController {
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @GetMapping("/{postId}")
    public Result get(@PathVariable Integer postId) throws ResultException {
        Post post = postService.get(postId);
        return Result.success().add("post", post);
    }

    @GetMapping("/{postId}/c")
    public Result get(@PathVariable Integer postId, Page page) {
        List<Comment> comments = commentService.getByPostIdAndPage(postId, page);
        return Result.success().add("post", comments);
    }

    @PostMapping("")
    public Result add(HttpServletRequest request, String title, String content, Integer topicId) throws ResultException {
        Post post = postService.add(title, content, topicId, SessionUtil.getUser(request));
        return Result.success().add("post", post);
    }
}
