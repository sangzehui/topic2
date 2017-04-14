package com.sang.topic.service.impl;


import com.sang.topic.common.constants.CommonConstants;
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
    public User add(User user) {
        if (user.getRoleId() == null)
            user.setRoleId(CommonConstants.Role.NORMAL);
        if (user.getAvailable() == null)
            user.setAvailable(CommonConstants.Available.AVAILABLE);
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
        if (user == null)
            throw new ResultException(MessageConstants.USER_NOT_FOUND, ResultConstants.NOT_FOUND);
        return user;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getAll(Page page) {
        org.springframework.data.domain.Page<User> p = userRepository.findAll(page.toPageable());
        page.setCount(p.getTotalElements());
        return p.getContent();
    }

    @Override
    public long getCount() {
        return userRepository.count();
    }

    @Override
    public User save(User user) throws ResultException {
        User u = userRepository.findOne(user.getId());
        if(u == null)
            throw new ResultException(MessageConstants.USER_NOT_FOUND, ResultConstants.NOT_FOUND);
        u.setRoleId(user.getRoleId());
        return userRepository.save(u);
    }
}
