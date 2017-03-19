package com.sang.topic.common.constants;


public interface MessageConstants {
    String FIELD_VALIDATION_SUCCESS = "字段验证成功";
    String FIELD_VALIDATION_FAIL = "字段验证失败";


    String USER_CREATE_SUCCESS = "创建用户名成功";
    String USER_CREATE_FAIL = "创建用户名失败";
    String USER_CREATE_REPEAT = "用户名重复";

    String USER_LOGIN_SUCCESS = "登录成功";
    String USER_LOGIN_FAIL = "用户名或密码错误";
    String USER_PASSWORD_FAIL = "旧密码错误";
    String USER_LOGIN_REQUIRE = "请登录后操作";

    String USER_SAVE_FAIL = "用户信息保存失败";
    String USER_SAVE_SUCCESS = "用户信息保存成功";


    String POST_CREATE_SUCCESS = "发表成功";
    String POST_CREATE_FAIL = "发表失败";


    String UPLOAD_FAIL = "上传文件失败";
    String UPLOAD_EMPTY = "上传文件为空";
    String UPLOAD_NOT_SUPPORT = "不支持的文件格式";
}
