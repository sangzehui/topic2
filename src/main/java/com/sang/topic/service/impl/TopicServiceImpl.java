package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.constants.ResultConstants;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.dao.TopicRepository;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    private EntityManager em;

    @Override
    public List<Topic> getFirstLevel() {
        return topicRepository.findByLevel(1);
    }

    @Override
    public List<Topic> getSecondLevel() {
        return topicRepository.findByLevel(2);
    }

    @Transactional
    @Override
    public Topic add(String name, Integer parentId) throws ResultException {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setAvailable(1);
        topic.setParentId(parentId);
        if (parentId != 0) {
            Topic parent = topicRepository.findOne(parentId);
            if (parent == null)
                throw new ResultException(MessageConstants.TOPIC_NOT_FOUND, ResultConstants.NOT_FOUND);
            topic.setLevel(parent.getLevel() + 1);
        } else {
            topic.setLevel(1);
        }
        topicRepository.save(topic);
        return topic;
    }

    @Transactional
    @Override
    public Topic add(String name) throws ResultException {
        return this.add(name, 0);
    }

    @Override
    public Topic get(Integer id) throws ResultException {
        Topic topic = topicRepository.findOne(id);
        if (topic == null)
            throw new ResultException(MessageConstants.TOPIC_NOT_FOUND, ResultConstants.NOT_FOUND);
        return topic;
    }

    @Override
    public List<Topic> getChildren(Integer id) throws ResultException {
        List<Topic> list = topicRepository.findByParentId(id);
        return list;
    }

    @Override
    public List<Topic> getBrother(Integer id) throws ResultException {
        Topic topic = topicRepository.findOne(id);
        if (topic == null)
            throw new ResultException(MessageConstants.TOPIC_NOT_FOUND, ResultConstants.NOT_FOUND);
        Topic parentTopic = topicRepository.findOne(topic.getParentId());
        if (parentTopic == null)
            return new ArrayList<>();
        List<Topic> list = topicRepository.findByParentId(parentTopic.getId());
        return list;
    }
}
