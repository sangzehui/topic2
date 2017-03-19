package com.sang.topic.service.impl;


import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.model.Result;
import com.sang.topic.dao.TopicRepository;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;

    @Transactional
    @Override
    public Result add(String name) {
        Topic topic = new Topic();
        topic.setName(name);
        topicRepository.save(topic);
        return Result.success("").add("topic", topic);
    }
}
