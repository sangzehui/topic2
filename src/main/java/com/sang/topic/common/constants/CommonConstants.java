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
