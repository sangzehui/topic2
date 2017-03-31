package com.sang.topic.util;

import com.sang.topic.common.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by sh on 2017/3/19.
 */
public class SessionUtil {
    private static final String SESSION_USER = "sessionUser";
    public static User addUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute(SESSION_USER, user);
        return user;
    }

    public static void removeUser(HttpServletRequest request) {
        request.getSession().removeAttribute(SESSION_USER);
        request.getSession().invalidate();
    }

    public static User getUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute(SESSION_USER);
    }
}
