package com.sang.topic.service;


import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;

public interface TopicService {
    Topic add(String name);

    Topic get(Integer id) throws ResultException;
}
