package com.sang.topic.admin.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
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
    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("admin/index");
    }

    @GetMapping("/t")
    public ModelAndView topicIndex() {
        return new ModelAndView("admin/topic");
    }
}
