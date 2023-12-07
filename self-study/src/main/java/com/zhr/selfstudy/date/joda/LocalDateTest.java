package com.zhr.selfstudy.date.joda;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LocalDate
 * @Date 2019-10-21 10:39
 **/
public class LocalDateTest {

    public static void main(String[] args) {
        //获取当前年月日
        LocalDate localDate = LocalDate.now();
        //构造指定的年月日
        LocalDate localDate1 = LocalDate.of(2019, 9, 10);

        int year = localDate.getYear();
        System.out.println("year = " + year);
        int year1 = localDate.get(ChronoField.YEAR);
        System.out.println("year1 = " + year1);
        Month month = localDate.getMonth();
        System.out.println("month = " + month);
        int month1 = localDate.get(ChronoField.MONTH_OF_YEAR);
        System.out.println("month1 = " + month1);
        int day = localDate.getDayOfMonth();
        System.out.println("day = " + day);
        int day1 = localDate.get(ChronoField.DAY_OF_MONTH);
        System.out.println("day1 = " + day1);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        int dayOfWeek1 = localDate.get(ChronoField.DAY_OF_WEEK);
        System.out.println("dayOfWeek1 = " + dayOfWeek1);

        String format = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("format ********************" + format);
    }
}
