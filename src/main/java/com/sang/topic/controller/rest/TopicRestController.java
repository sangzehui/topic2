package com.sang.topic.controller.rest;

import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/rest/t")
public class TopicRestController {
    @Autowired
    TopicService topicService;
    @Autowired
    PostService postService;

    @GetMapping("/{topicId}")
    public Result get(@PathVariable Integer topicId) {
        try {
            Topic topic = topicService.get(topicId);
            List<Topic> topics = topicService.getChildren(topicId);
            return Result.success().add("topic", topic)
                    .add("childTopics", topics);
        } catch (Exception e) {
            return Result.exception(e);
        }
    }

    @GetMapping("/{topicId}/p")
    public Result getPosts(@PathVariable Integer topicId, Page page) {
        try {
            List<Post> posts = postService.getByTopicId(topicId, page);
            return Result.success()
                    .add("posts", posts)
                    .add("page", page);
        } catch (Exception e) {
            return Result.exception(e);
        }
    }

    @GetMapping("/l/{level}")
    public Result getByLevel(@PathVariable Integer level) {
        try {
            List<Topic> topics = topicService.getByLevel(level);
            return Result.success().add("topics", topics);
        } catch (Exception e){
           return Result.exception(e);
        }
    }

    @PostMapping("")
    public Result add(String name) {
        try {
            Topic topic = topicService.add(name);
            return Result.success().add("topic", topic);
        } catch (Exception e) {
            return Result.exception(e);
        }
    }
}
