package com.sang.topic.controller.rest;

import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.Result;
import com.sang.topic.util.SessionUtil;
import com.sang.topic.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/rest")
public class LoginRestController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(HttpServletRequest request, String username, String password) {
        try {
            User user = userService.register(username, password);
            Result result = Result.success();
            result.add("user", user);
            result.add("jsessionid",request.getSession().getId());
            SessionUtil.addUser(request, (User) result.get("user"));
            return result;
        } catch (Exception e) {
            return Result.exception(e);
        }
    }

    @GetMapping("/login")
    public Result login(HttpServletRequest request, String username, String password) {
        try {
            User user = userService.login(username, password);
            Result result = Result.success();
            result.add("user", user);
            result.add("jsessionid",request.getSession().getId());
            SessionUtil.addUser(request, (User) result.get("user"));
            return result;
        } catch (Exception e) {
            return Result.exception(e);
        }
    }
}
