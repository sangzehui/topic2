package com.sang.topic.dao;


import com.sang.topic.common.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopicRepository extends JpaRepository<Topic, Integer> {
    List<Topic> findByLevel(Integer level);

    List<Topic> findByParentId(Integer parentId);

    List<Topic> findByIdIn(List<Integer> parentIds);
}
