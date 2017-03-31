package com.sang.topic.service.impl;


import com.sang.topic.common.constants.MessageConstants;
import com.sang.topic.common.constants.ResultConstants;
import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;
import com.sang.topic.dao.UserRepository;
import com.sang.topic.service.UserService;
import com.sang.topic.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public User add(User user){
        if(user.getRoleId() == null)
            user.setRoleId(3);
        if(user.getAvailable() == null)
            user.setAvailable(1);
        user.setCreateTime(new Date());
        return userRepository.save(user);
    }

    @Transactional
    @Override
    public User register(String username, String password) throws ResultException {
        if (userRepository.findByUsername(username) != null)
            throw new ResultException(MessageConstants.USER_CREATE_REPEAT);
        User user = new User();
        user.setUsername(username);
        user.setPassword(SecurityUtil.encryptPassword(password));
        return this.add(user);
    }

    @Override
    public User login(String username, String password) throws ResultException {
        User user = userRepository.findByUsernameAndPassword(username,
                SecurityUtil.encryptPassword(password));
        if (user == null)
            throw new ResultException(MessageConstants.USER_LOGIN_FAIL);
        return user;
    }

    @Override
    public User get(Integer id) throws ResultException {
        User user = userRepository.findOne(id);
        if(user == null)
            throw new ResultException(MessageConstants.USER_NOT_FOUND, ResultConstants.NOT_FOUND);
        return user;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll(new Page().toPageable()).getContent();
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }
}
