package com.sang.topic.service;


import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;

import java.util.List;

public interface CommentService {
    List<Comment> getByPostIdAndPage(Integer topicId, Page page);

    Comment add(String content, Integer postId, User user) throws ResultException;
}
