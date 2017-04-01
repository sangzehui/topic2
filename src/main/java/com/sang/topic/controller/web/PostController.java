package com.sang.topic.controller.web;

import com.sang.topic.common.entity.Post;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.service.CommentService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/p")
public class PostController {
    @Autowired
    TopicService topicService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    @GetMapping("/{postId}")
    public ModelAndView post(@PathVariable Integer postId, Page page, Map<String, Object> model) throws ResultException {
        Post post = postService.get(postId);
        model.put("post", post);
        model.put("comments", commentService.getByPostIdAndPage(postId, page));
        model.put("postId", postId);
        model.put("parentTopic", topicService.getParentTopic(post.getTopicId()));
        return new ModelAndView("post", model);
    }
}
