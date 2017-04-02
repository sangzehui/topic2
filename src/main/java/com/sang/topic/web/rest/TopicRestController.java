package com.sang.topic.web.rest;

import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
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
    public Result get(@PathVariable Integer topicId) throws ResultException {
        Topic topic = topicService.get(topicId);
        List<Topic> topics = topicService.getChildren(topicId);
        return Result.success().add("topic", topic)
                .add("childTopics", topics);
    }

    @GetMapping("/{topicId}/p")
    public Result getPosts(@PathVariable Integer topicId, Page page) {
        List<Post> posts = postService.getByTopicId(topicId, page);
        return Result.success()
                .add("posts", posts)
                .add("page", page);
    }

    @PostMapping("")
    public Result add(String name, Integer parentId) throws ResultException {
        Topic topic = topicService.add(name, parentId);
        return Result.success().add("topic", topic);
    }
}
