package com.sang.topic.admin.controller;

import com.sang.topic.common.model.Page;
import com.sang.topic.service.UserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sh on 2017/4/2.
 */
@RequestMapping("/admin")
@Controller
public class IndexAdminController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("admin/index");
    }

    @GetMapping("/t")
    public ModelAndView topicIndex() {
        return new ModelAndView("admin/topic");
    }

    @GetMapping("/u")
    public ModelAndView userIndex(Page page, Model model) {
        model.addAttribute("users", userService.getAll(page));
        model.addAttribute("page", page);
        return new ModelAndView("admin/user");
    }
}
