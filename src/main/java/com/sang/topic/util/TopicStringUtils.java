package com.sang.topic.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sh on 2017/4/16.
 */
public class TopicStringUtils {
    public static List<Integer> toIntegerList(String str) {
        List<Integer> list = new ArrayList<>();
        String[] arr = str.split(",");
        for (String s : arr) {
            Integer i = Integer.valueOf(s);
            list.add(i);
        }
        return list;
    }

    public static String integerToString(Integer... args) {
        StringBuilder str = new StringBuilder();
        for (Integer s : args) {
            str.append(",");
            str.append(s);
        }
        if(args.length > 0)
            return str.substring(1);
        return "";
    }
}
