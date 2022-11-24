package com.example.factory.utils;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * common
 *
 * @author super
 * @date 2022/1/12 11:51
 */
@Slf4j
public class Common {

    /**
     * 获取当前天
     *
     * @return 当天整型日期
     */
    public static Long getCurrentDay() {
        return Long.valueOf(unixFormat(currentUnixTime(), "yyyyMMdd"));
    }

    /**
     * 昨日字符串日期
     *
     * @return 昨日字符串日期
     */
    public static Long getYesterdayL() {
        return Long.valueOf(unixFormat(currentUnixTime() - 86400, "yyyyMMdd"));
    }

    /**
     * 获取当前unix时间
     *
     * @return 时间戳
     */
    public static Long currentUnixTime() {
        return System.currentTimeMillis()/(1000);
    }

    /**
     * unix时间转换
     * @param time 时间戳（s）
     * @param f 输出日期类型
     * @return 日期
     */
    public static String unixFormat(Long time,String f){
        if (null == time) time = currentUnixTime();
        if (null == f) f = "yyyy-MM-dd HH:mm:ss";
        return new SimpleDateFormat(f).format(new Date(time * 1000));
    }

    /**
     * 日期转时间戳
     * @param date 日期（s）
     * @param f 输出日期类型
     * @return 日期
     */
    public static Long date2Unix(String date,String f){
        if (null == f) f = "yyyy-MM-dd HH:mm:ss";
        try {
            return Long.parseLong(String.valueOf(new SimpleDateFormat(f).parse(date).getTime())) / 1000;
        } catch (Exception e) {
            return 0L;
        }
    }

}
