package com.sang.topic.service;


import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.TreeView;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public interface TopicService {
    void getWithPageType(Integer topicId, Page page, Map<String, Object> model) throws ResultException;

    Topic add(String name, Integer parentId) throws ResultException;

    Topic get(Integer id) throws ResultException;

    List<Topic> getChildren(Integer id) throws ResultException;

    List<Topic> getBrother(Integer id) throws ResultException;

    List<Topic> getParentTopic(Integer topicId);

    List<TreeView> getTreeView();

    Topic save(Integer topicId, String name, Integer available, Integer orderType) throws ResultException;

    Topic save(Topic topic) throws ResultException;

    List<Topic> getFirstLevel();
}
