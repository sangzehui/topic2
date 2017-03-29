package com.sang.topic.dao;


import com.sang.topic.common.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Page<Post> findByTopicId(Integer topicId, Pageable pageable);

    Long countByTopicId(Integer topicId);
}
