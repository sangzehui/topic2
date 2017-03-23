package com.sang.topic.service;


import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {
    List<Post> getByTopicId(Integer topicId, Page page);

    Post get(Integer id) throws ResultException;

    Post add(String title, String content, Integer TopicId, User user) throws ResultException;

    @Transactional
    Post save(Post post);
}
