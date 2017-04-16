package com.sang.topic.common.constants;

/**
 * Created by sh on 2017/4/11.
 */
public interface CommonConstants {
    interface OrderType {
        int CREATE_TIME_FIRST = 1;
        int UPDATE_TIME_FIRST = 2;
        int DEFAULT = UPDATE_TIME_FIRST;
    }

    interface PageType {
        int SHOW_CHILD_TOPIC = 1;
        int SHOW_POST = 2;
        int DEFAULT = SHOW_POST;
    }

    interface SecNav {
        int NONE = 0;
        int BROTHER = 1;
        int DEFAULT = BROTHER;
    }

    interface PostShowTypes {
        int TITLE = 1;
        int AUTHOR = 2;
        int CREATE_TIME = 3;
        int UPDATE_TIME = 4;
        int COMMENT_NUMBER = 5;

        String DEFAULT = "1,2,3,4,5";
    }

    interface Role {
        int SUPER_ADMIN = 1;
        int MANAGER = 2;
        int NORMAL = 3;
    }

    interface Available {
        int AVAILABLE = 1;
        int UNAVAILABLE = 0;
    }
}
