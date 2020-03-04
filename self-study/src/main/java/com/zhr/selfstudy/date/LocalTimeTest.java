package com.zhr.selfstudy.date;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LocalTimeTest
 * @Date 2019-10-21 10:43
 * @description 获取日期时分秒
 **/
public class LocalTimeTest {

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.of(13, 51, 10);
        LocalTime localTime1 = LocalTime.now();

        //获取小时
        int hour = localTime.getHour();
        System.out.println("hour = " + hour);
        int hour1 = localTime.get(ChronoField.HOUR_OF_DAY);
        System.out.println("hour1 = " + hour1);

        //获取分
        int minute = localTime.getMinute();
        System.out.println("minute = " + minute);
        int minute1 = localTime.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println("minute1 = " + minute1);

        //获取秒
        int second = localTime.getSecond();
        System.out.println("second = " + second);
        int second1 = localTime.get(ChronoField.SECOND_OF_MINUTE);
        System.out.println("second1 = " + second1);
    }
}
