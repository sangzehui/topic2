package com.sang.topic.service;


import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;

public interface PostService {
    Result getByTopicId(Integer topicId, Page page);

    Result add(String title, String content, Integer TopicId, User user);
}
