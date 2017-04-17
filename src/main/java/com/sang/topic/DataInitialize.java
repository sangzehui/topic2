package com.sang.topic;

import com.sang.topic.common.constants.CommonConstants;
import com.sang.topic.common.entity.Post;
import com.sang.topic.common.entity.Topic;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.service.CommentService;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import com.sang.topic.util.TopicStringUtils;
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
            User adminUser = new User();
            adminUser.setId(1);
            adminUser.setUsername("admin");
            adminUser.setPassword(SecurityUtil.encryptPassword("admin"));
            adminUser.setRoleId(CommonConstants.Role.SUPER_ADMIN);
            userService.add(adminUser);
            User testUser = new User();
            testUser.setUsername("test-user");
            testUser.setPassword(SecurityUtil.encryptPassword("123456"));
            userService.add(testUser);

            Topic t1 = topicService.add("topic", 0);
            t1.setPageType(CommonConstants.PageType.SHOW_CHILD_TOPIC);
            topicService.save(t1);

            Topic blog = topicService.add("博客", t1.getId());
            blog.setSecNav(CommonConstants.SecNav.NONE);
            blog.setOrderType(CommonConstants.OrderType.CREATE_TIME_FIRST);
            blog.setPostShowTypes(TopicStringUtils.integerToString(
                    CommonConstants.PostShowTypes.TITLE
                    ));
            topicService.save(blog);
            postService.add("第一篇博客标题", "第一篇博客内容", blog.getId(), adminUser);

            Topic bbs = topicService.add("论坛", t1.getId());
            bbs.setPageType(CommonConstants.PageType.SHOW_CHILD_TOPIC);
            topicService.save(bbs);

            List<String> list = Arrays.asList("闲聊", "技术", "游戏");
            for (String name : list) {
                try {
                    Topic t = topicService.add(name, bbs.getId());
                    Random random = new Random(System.currentTimeMillis());
                    int n = random.nextInt(4) + 1;
                    Post post = postService.add("文章标题["+t.getName()+"]","文章内容", t.getId(), adminUser);
                    for (int j = 1; j <= n + 18; j++) {
                        commentService.add("评论" + j, post.getId(), adminUser);
                    }
                } catch (ResultException e) {
                    e.printStackTrace();
                }
            }
            logger.info("Data init success!");
        }
    }
}
