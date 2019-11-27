package com.kk.utils;

import java.util.Date;

public class TimeUtil {

    public static void userTime(Date beginDate) {
        Date endDate = new Date();
        long time = endDate.getTime() - beginDate.getTime();
        String timeStr;
        if (time < 1000) {
            timeStr = time + "ms";
        } else if (time < 1000 * 60) {
            timeStr = time / 1000 + "s";
        } else {
            timeStr = time / 1000 / 60 + "m";
        }
        System.out.println("用时：" + timeStr);
    }

}
