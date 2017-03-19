package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;
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
    public Result getByTopicId(Integer topicId, Page page) {
        List<Post> list = postRepository.findByTopicId(topicId, page.toPageReq());
        return Result.success("").add("posts", list).add("page", page);
    }

    @Transactional
    @Override
    public Result add(String title, String content, Integer topicId, User user) {
        if(user == null)
            return Result.fail(MessageConstants.USER_LOGIN_REQUIRE);
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        post.setTopicId(topicId);
        post.setUserId(user.getId());
        post.setUsername(user.getUsername());
        post.setCreateTime(new Date());
        postRepository.save(post);
        return Result.success("").add("post", post);
    }
}
