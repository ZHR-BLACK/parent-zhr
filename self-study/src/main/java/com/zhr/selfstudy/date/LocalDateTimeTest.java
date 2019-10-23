package com.zhr.selfstudy.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LocalDateTimeTest
 * @Date 2019-10-21 10:45
 * @description todo
 **/
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前日期 ==================== " + localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime2 = LocalDateTime.of(localDate, localTime);
        LocalDateTime localDateTime3 = localDate.atTime(localTime);
        LocalDateTime localDateTime4 = localTime.atDate(localDate);

        //增加一年
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        System.out.println("增加一年 ===================== " + localDateTime);
        //减少一个月
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);
        System.out.println("减少一个月 ===================== " + localDateTime);

        //修改年为2019
        localDateTime = localDateTime.withYear(2019);
        System.out.println("修改2019 ===================== " + localDateTime);
        //修改为2022
        localDateTime = localDateTime.with(ChronoField.YEAR, 2022);
        System.out.println("修改2022 ===================== " + localDateTime);
        String format = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("format = " + format);

    }
}
