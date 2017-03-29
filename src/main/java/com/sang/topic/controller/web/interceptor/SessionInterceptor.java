package com.sang.topic.controller.web.interceptor;

import com.sang.topic.common.entity.User;
import com.sang.topic.service.TopicService;
import com.sang.topic.util.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SessionInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    TopicService topicService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = SessionUtil.getUser(request);
        if(user == null)
            response.sendRedirect(request.getContextPath()+"/login");
        return super.preHandle(request, response, handler);
    }
}
