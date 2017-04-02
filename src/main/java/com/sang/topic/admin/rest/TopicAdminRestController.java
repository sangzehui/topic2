package com.sang.topic.admin.rest;

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
@RequestMapping("/admin/rest/t")
public class TopicAdminRestController {
    @Autowired
    TopicService topicService;
    @Autowired
    PostService postService;
}
