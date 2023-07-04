package com.zhr.selfstudy.date.joda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LocalDateWholeTest
 * @Date 2020-05-12 11:10
 * @description 计算当前日期下一个整点时间
 * 可以避免23:00之后超过24
 **/
public class LocalDateWholeTest {

    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HHmmss");

        LocalDateTime startTime = LocalDateTime.now().plusHours(1).toLocalDate().atTime(LocalDateTime.now().plusHours(1).getHour(), 0, 0);
//        LocalDateTime endTime = LocalDateTime.now().plusHours(3).toLocalDate().atTime(LocalDateTime.now().plusHours(3).getHour(), 0, 0);

        String startTimeStr = df.format(startTime);
//        String endTimeStr = df.format(endTime);
//        String localTime = startTimeStr + "-" + endTimeStr;
        System.out.println("startTimeStr = " + startTimeStr);
//        System.out.println("endTimeStr = " + endTimeStr);
    }
}
