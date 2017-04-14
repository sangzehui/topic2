package com.sang.topic.service;


import com.sang.topic.common.entity.User;
import com.sang.topic.common.exception.ResultException;
import com.sang.topic.common.model.Page;

import java.util.List;

public interface UserService {
    User register(String username, String password) throws ResultException;

    User login(String username, String password) throws ResultException;

    User add(User user);

    User get(Integer id) throws ResultException;

    User getByUsername(String username);

    List<User> getAll(Page page);

    long getCount();

    User save(User user) throws ResultException;
}
