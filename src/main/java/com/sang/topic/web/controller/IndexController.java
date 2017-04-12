package com.sang.topic.web.controller;

import com.sang.topic.common.model.Page;
import com.sang.topic.service.PostService;
import com.sang.topic.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        return new ModelAndView("web/login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("web/register");
    }

    @GetMapping("")
    public ModelAndView index(Map<String, Object> model, Page page) {
        return new ModelAndView("web/index");
    }

    @RequestMapping("/400")
    public ModelAndView error400(Map<String, Object> model){
        model.put("status", 400);
        model.put("message", "错误的请求方式");
        return new ModelAndView("error");
    }

    @RequestMapping("/404")
    public ModelAndView error404(Map<String, Object> model){
        model.put("status", 404);
        model.put("message", "找不到页面");
        return new ModelAndView("error");
    }

    @RequestMapping("/500")
    public ModelAndView error500(Map<String, Object> model){
        model.put("status", 500);
        model.put("message", "服务器发生错误");
        return new ModelAndView("error");
    }
}
