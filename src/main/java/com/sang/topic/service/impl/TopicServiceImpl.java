package com.sang.topic.service.impl;


import com.sang.topic.common.constants.CommonConstants;
import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.constants.ResultConstants;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.TreeView;
import com.sang.topic.dao.TopicRepository;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.*;

@Service
public class TopicServiceImpl implements TopicService {
    @Autowired
    TopicRepository topicRepository;
    @Autowired
    PostService postService;
    @Autowired
    private EntityManager em;

    @Override
    public void getWithPageType(Integer topicId, Page page, Map<String, Object> model) throws ResultException {
        Topic topic = topicRepository.findOne(topicId);
        if(topic.getPageType() == CommonConstants.PageType.SHOW_CHILD_TOPIC){
            model.put("childTopics", this.getChildren(topicId));
        }else if(topic.getPageType() == CommonConstants.PageType.SHOW_POST){
            model.put("posts", postService.getByTopicId(topicId, page));
            model.put("nav2", this.getBrother(topicId));
            model.put("page", page);
        }
        model.put("topicId", topicId);
    }

    @Transactional
    @Override
    public Topic add(String name, Integer parentId) throws ResultException {
        Topic topic = new Topic();
        topic.setName(name);
        topic.setAvailable(1);
        topic.setParentId(parentId);
        topic.setOrderType(CommonConstants.OrderType.DEFAULT);
        topic.setPageType(CommonConstants.PageType.DEFAULT);
        if (parentId != 0) {
            Topic parent = topicRepository.findOne(parentId);
            if (parent == null)
                throw new ResultException(MessageConstants.TOPIC_NOT_FOUND, ResultConstants.NOT_FOUND);
            if (parent.isRoot())
                topic.setParentIds(parentId.toString());
            else
                topic.setParentIds(parent.getParentIds() + "," + parentId);
        }
        topicRepository.save(topic);
        return topic;
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

    @Override
    public List<Topic> getParentTopic(Integer topicId) {
        Topic t = topicRepository.findOne(topicId);
        List<Integer> idList = new ArrayList<>();
        String[] ids = t.getParentIds().split(",");
        for (String id : ids) {
            idList.add(Integer.valueOf(id));
        }
        List<Topic> list = topicRepository.findByIdIn(idList);
        list.add(t);
        return list;
    }

    @Override
    public List<TreeView> getTreeView() {
        TreeView root = new TreeView();
        List<Topic> list = topicRepository.findAll();
        list.forEach(t -> {
            if (t.isRoot()) {
                root.setId(t.getId());
                root.setText(t.getName());
            } else {
                root.addNode(t.getParentIds(), t.getId(), t.getName());
            }
        });
        List<TreeView> result = new ArrayList<>();
        result.add(root);
        return result;
    }

    @Override
    public Topic save(Integer topicId, String name, Integer available, Integer orderType) throws ResultException {
        Topic topic = topicRepository.findOne(topicId);
        if (topic == null)
            throw new ResultException(MessageConstants.TOPIC_NOT_FOUND, ResultConstants.NOT_FOUND);
//        topic.setName(name);
        topic.setAvailable(available);
        topic.setOrderType(orderType);
        return this.save(topic);
    }

    @Override
    public Topic save(Topic topic) throws ResultException {
        Topic t = topicRepository.findOne(topic.getId());
        t.setPageType(topic.getPageType());
        t.setOrderType(topic.getOrderType());
        t.setAvailable(topic.getAvailable());
        t.setName(topic.getName());
        return topicRepository.save(t);
    }

    @Override
    public List<Topic> getFirstLevel() {
        return topicRepository.findByParentId(0);
    }
}
