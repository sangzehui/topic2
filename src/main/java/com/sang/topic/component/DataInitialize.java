package com.sang.topic.component;

import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.entity.User;
import com.sang.topic.service.CommentService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 初始化条件  数据库中用户表为空
 * 作用       初始化数据库的基础数据
 */
@Component
public class DataInitialize implements InitializingBean {
    @Autowired
    UserService userService;
    @Autowired
    TopicService topicService;
    @Autowired
    PostService postService;
    @Autowired
    CommentService commentService;

    Logger logger = Logger.getLogger(DataInitialize.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Data init");
        long count = userService.getCount();
        if (count <= 0) {
            logger.info("Begin Data init");
            User user = new User();
            user.setUsername("admin");
            user.setPassword(SecurityUtil.encryptPassword("admin"));
            user.setRoleId(1);
            userService.add(user);

            Topic t = topicService.add("话题");
            Topic topic = topicService.add("主页", t.getId());

            Post post = postService.add("第一篇文章标题", "第一篇文章内容", topic.getId(), user);

            for (int i = 1; i <= 21; i++) {
                commentService.add("评论" + i, post.getId(), user);
            }
            logger.info("Data init success!");
        }
    }
}
