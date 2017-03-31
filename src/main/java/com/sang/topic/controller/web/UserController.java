package com.sang.topic.controller.web;

import com.sang.topic.common.exception.ResultException;
import com.sang.topic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/u")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{userId}")
    public ModelAndView index(@PathVariable Integer userId, Map<String, Object> model) throws ResultException {
        model.put("user", userService.get(userId));
        return new ModelAndView("user");
    }
}
