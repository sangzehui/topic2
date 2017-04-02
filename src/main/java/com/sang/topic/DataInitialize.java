package com.sang.topic;

import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.service.CommentService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
            user.setId(1);
            user.setUsername("admin");
            user.setPassword(SecurityUtil.encryptPassword("admin"));
            user.setRoleId(1);
            userService.add(user);

            Topic topic = topicService.add("Topic", 0);

            List<String> list = Arrays.asList("闲聊", "技术", "游戏");
            for (String name : list) {
                new Thread(() -> {
                    try {
                        Topic t = topicService.add(name, topic.getId());
                        Random random = new Random(System.currentTimeMillis());
                        int n = random.nextInt(6) + 1;
                        for (int i = 1; i <= n; i++) {
                            Post post = postService.add("第" + i + "篇[" + t.getName() + "]文章",
                                    "第" + i + "篇[" + t.getName() + "]文章内容", t.getId(), user);
                            for (int j = 1; j <= n + 18; j++) {
                                commentService.add("评论" + j, post.getId(), user);
                            }
                            logger.info("Data init success!");
                        }
                    } catch (ResultException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        }
    }
}
