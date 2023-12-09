package com.zjj.origod.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *  返回当前时间字符串
 */
public class TimeUtil {
    public static String getCurrentTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
