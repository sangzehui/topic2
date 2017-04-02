package com.sang.topic.admin.controller.interceptor;

import com.sang.topic.common.entity.User;
import com.sang.topic.util.SessionUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by sh on 2017/4/2.
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user = SessionUtil.getUser(request);
        if(user == null || user.getRoleId() != 1) {
            response.sendRedirect(request.getContextPath()+"/400");
            return true;
        }
        return super.preHandle(request, response, handler);
    }
}
