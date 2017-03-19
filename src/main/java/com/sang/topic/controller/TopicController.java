package com.sang.topic.controller;

import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/t")
public class TopicController {
    @Autowired
    TopicService topicService;
    @Autowired
    PostService postService;

    @GetMapping("/{topicId}")
    public Result getByPage(Page page, @PathVariable("topicId") Integer topicId) {
        try {
            return postService.getByTopicId(topicId, page);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @PostMapping("")
    public Result add(String name) {
        try {
            return topicService.add(name);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
