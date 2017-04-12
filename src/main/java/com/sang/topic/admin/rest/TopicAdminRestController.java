package com.sang.topic.admin.rest;

import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/rest/t")
public class TopicAdminRestController {
    @Autowired
    TopicService topicService;
    @Autowired
    PostService postService;

    @GetMapping("/tree")
    public Result getTreeView() {
        return Result.success().add("tree", topicService.getTreeView());
    }

    @PutMapping("/{topicId}")
    public Result saveTopic(@PathVariable Integer topicId, Topic topic) throws ResultException {
        return Result.success().add("topic", topicService.save(topic));
    }

    @GetMapping("/{topicId}")
    public Result get(@PathVariable Integer topicId) throws ResultException {
        return Result.success().add("topic", topicService.get(topicId));
    }

    @PostMapping("")
    public Result add(Integer parentId, String name) throws ResultException {
        return Result.success().add("topic", topicService.add(name, parentId));
    }
}
