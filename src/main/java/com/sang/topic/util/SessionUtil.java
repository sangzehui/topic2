package com.sang.topic.util;

import com.sang.topic.common.entity.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;

/**
 * Created by sh on 2017/3/19.
 */
public class SessionUtil {
    public static User addUser(HttpServletRequest request, User user) {
        request.getSession().setAttribute("sessionUser", user);
        return user;
    }

    public static User getUser(HttpServletRequest request) {
        return (User) request.getSession().getAttribute("sessionUser");
    }
}
