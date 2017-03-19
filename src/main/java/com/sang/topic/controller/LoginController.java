package com.sang.topic.controller;

import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.Result;
import com.sang.topic.util.SessionUtil;
import com.sang.topic.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(HttpServletRequest request, String username, String password) {
        try {
            Result result = userService.register(username, password);
            if(result.success()) {
                result.add("jsessionid",request.getSession().getId());
                SessionUtil.addUser(request, (User) result.get("user"));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }

    @GetMapping("/login")
    public Result login(HttpServletRequest request, String username, String password) {
        try {
            Result result = userService.login(username, password);
            if(result.success()) {
                result.add("jsessionid",request.getSession().getId());
                SessionUtil.addUser(request, (User) result.get("user"));
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail(e.getMessage());
        }
    }
}
