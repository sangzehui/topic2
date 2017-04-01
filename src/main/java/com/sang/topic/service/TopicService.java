package com.sang.topic.service;


import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TopicService {
    List<Topic> getFirstLevel();

    List<Topic> getSecondLevel();

    Topic add(String name, Integer parentId) throws ResultException;

    Topic get(Integer id) throws ResultException;

    List<Topic> getChildren(Integer id) throws ResultException;

    List<Topic> getBrother(Integer id) throws ResultException;

    List<Topic> getParentTopic(Integer topicId);
}
