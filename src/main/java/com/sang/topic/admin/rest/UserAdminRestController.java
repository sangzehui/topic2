package com.sang.topic.admin.rest;

import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.common.model.Result;
import com.sang.topic.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/rest/u")
public class UserAdminRestController {
    @Autowired
    UserService userService;

    @GetMapping("")
    public Result getAll(Page page) {
        return Result.success()
                .add("users", userService.getAll(page))
                .add("page", page);
    }

    @GetMapping("/{userId}")
    public Result get(@PathVariable Integer userId) throws ResultException {
        return Result.success().add("user", userService.get(userId));
    }

    @PutMapping("/{userId}")
    public Result save(@PathVariable Integer userId, User user) throws ResultException {
        return Result.success().add("user", userService.save(user));
    }

}
