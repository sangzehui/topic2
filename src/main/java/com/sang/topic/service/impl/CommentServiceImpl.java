package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.dao.CommentRepository;
import com.sang.topic.service.CommentService;
import com.sang.topic.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    PostService postService;
    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Comment> getByPostIdAndPage(Integer topicId, Page page) {
        org.springframework.data.domain.Page<Comment> p = commentRepository.findByPostId(topicId, page.toPageable());
        page.setCount(p.getTotalElements());
        return p.getContent();
    }

    @Transactional
    @Override
    public Comment add(String content, Integer postId, User user) throws ResultException {
        Post post = postService.get(postId);
        post.setCommentNumber(post.getCommentNumber() + 1);
        post.setUpdateTime(new Date());
        if (user == null)
            throw new ResultException(MessageConstants.USER_LOGIN_REQUIRE);
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUserId(user.getId());
        comment.setUsername(user.getUsername());
        comment.setPostId(postId);
        comment.setAvailable(1);
        comment.setFloor(post.getCommentNumber());
        postService.save(post);
        return commentRepository.save(comment);
    }
}
