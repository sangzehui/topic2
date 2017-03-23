package com.sang.topic.dao;


import com.sang.topic.common.entity.Post;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findByTopicId(int topicId, Pageable pageable);
}
