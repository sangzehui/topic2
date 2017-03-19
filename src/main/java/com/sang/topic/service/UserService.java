package com.sang.topic.service;


import com.sang.topic.common.model.Result;

public interface UserService {
    Result register(String username, String password);

    Result login(String username, String password);
}
