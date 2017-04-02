package com.sang.topic.web.rest;

import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Result;
import com.sang.topic.util.SessionUtil;
import com.sang.topic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@RequestMapping("/rest")
public class LoginRestController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public Result register(HttpServletRequest request, String username, String password) throws ResultException {
        User user = userService.register(username, password);
        Result result = Result.success();
        result.add("user", user);
        result.add("jsessionid", request.getSession().getId());
        SessionUtil.addUser(request, (User) result.get("user"));
        return result;
    }

    @PostMapping("/login")
    public Result login(HttpServletRequest request, String username, String password) {
        try {
            User user = userService.login(username, password);
            Result result = Result.success();
            result.add("user", user);
            result.add("jsessionid", request.getSession().getId());
            SessionUtil.addUser(request, (User) result.get("user"));
            return result;
        } catch (Exception e) {
            return Result.exception(e);
        }
    }

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        try {
            SessionUtil.removeUser(request);
            return Result.success();
        } catch (Exception e) {
            return Result.exception(e);
        }
    }
}
