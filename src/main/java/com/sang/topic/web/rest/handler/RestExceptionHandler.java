package com.sang.topic.web.rest.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sang.topic.common.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/3/31.
 */
public class RestExceptionHandler implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (!request.getRequestURL().toString().startsWith(request.getContextPath() + "/rest"))
            return null;
        response.setStatus(HttpStatus.OK.value()); //设置状态码
        response.setContentType(MediaType.APPLICATION_JSON_VALUE); //设置ContentType
        response.setCharacterEncoding("UTF-8"); //避免乱码
        response.setHeader("Cache-Control", "no-cache, must-revalidate");
        try {
            Result result = Result.exception(ex);
            String str = new ObjectMapper().writeValueAsString(result);
            response.getWriter().write(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
