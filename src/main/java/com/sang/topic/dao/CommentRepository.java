package com.sang.topic.dao;


import com.sang.topic.common.entity.Comment;
import com.sang.topic.common.model.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findByPostId(int topicId, Pageable pageable);
}
