package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.constants.ResultConstants;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.dao.PostRepository;
import com.sang.topic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public List<Post> getAll(Page page) {
        org.springframework.data.domain.Page<Post> p = postRepository.findAll(page.toPageable());
        page.setCount(p.getTotalElements());
        return p.getContent();
    }

    @Override
    public List<Post> getByTopicId(Integer topicId, Page page) {
        org.springframework.data.domain.Page<Post> p = postRepository.findByTopicId(topicId, page.toPageable());
        page.setCount(p.getTotalElements());
        return p.getContent();
    }

    @Override
    public Post get(Integer id) throws ResultException {
        Post post = postRepository.findOne(id);
        if (post == null)
            throw new ResultException(MessageConstants.POST_NOT_FOUND, ResultConstants.NOT_FOUND);
        return post;
    }

    @Transactional
    @Override
    public Post add(String title, String content, Integer topicId, User user) throws ResultException {
        if (user == null)
            throw new ResultException(MessageConstants.USER_LOGIN_REQUIRE);
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTopicId(topicId);
        post.setAvailable(1);
        post.setCommentNumber(0);
        post.setUserId(user.getId());
        post.setUsername(user.getUsername());
        post.setCreateTime(new Date());
        postRepository.save(post);
        return post;
    }

    @Transactional
    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }
}
