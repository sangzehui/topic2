package com.sang.topic.common.model;

import com.sang.topic.common.constants.ResultConstants;

import java.util.HashMap;
import java.util.Map;

public class Result {
    private String status;
    private String message;
    private Map<String, Object> data;

    private Result() {
    }

    public boolean success(){
        return getStatus().equals(ResultConstants.SUCCESS);
    }

    public static Result success(String message) {
        Result result = new Result();
        result.setStatus(ResultConstants.SUCCESS);
        result.setMessage(message);
        return result;
    }

    public static Result fail(String message) {
        Result result = new Result();
        result.setStatus(ResultConstants.FAIL);
        result.setMessage(message);
        return result;
    }

    public Result add(String name, Object value) {
        if(data == null)
            data = new HashMap<>();
        data.put(name, value);
        return this;
    }

    public Object get(String name){
        return getData().get(name);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
