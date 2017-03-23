package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.constants.ResultConstants;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
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
    public Topic add(String name) {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setAvailable(1);
        topicRepository.save(topic);
        return topic;
    }

    @Override
    public Topic get(Integer id) throws ResultException {
        Topic topic = topicRepository.findOne(id);
        if(topic == null)
            throw new ResultException(MessageConstants.TOPIC_NOT_FOUND, ResultConstants.NOT_FOUND);
        return topic;
    }
}
