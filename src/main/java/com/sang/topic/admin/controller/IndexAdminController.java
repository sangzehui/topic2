package com.sang.topic.admin.controller;

import org.springframework.stereotype.Controller;
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
    public ModelAndView idnex(){
        return new ModelAndView("admin/index");
    }
}
