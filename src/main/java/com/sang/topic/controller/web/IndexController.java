package com.sang.topic.controller.web;

import com.sang.topic.common.model.Page;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class IndexController {
    @Autowired
    PostService postService;
    @Autowired
    TopicService topicService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register");
    }

    @GetMapping("")
    public ModelAndView index(Map<String, Object> model, Page page) {
        model.put("posts", postService.getAll(page));
        model.put("nav2", topicService.getSecondLevel());
        model.put("page", page);
        return new ModelAndView("topic");
    }
}
