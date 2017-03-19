package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.model.Result;
import com.sang.topic.dao.UserRepository;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public Result register(String username, String password) {
        if (userRepository.findByUsername(username) != null)
            return Result.fail(MessageConstants.USER_CREATE_REPEAT);
        User user = new User();
        user.setUsername(username);
        user.setPassword(SecurityUtil.encryptPassword(password));
        userRepository.save(user);
        return Result.success("").add("user", user);
    }

    @Override
    public Result login(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,
                SecurityUtil.encryptPassword(password));
        if (user == null)
            return Result.fail(MessageConstants.USER_LOGIN_FAIL);
        return Result.success("").add("user", user);
    }
}
