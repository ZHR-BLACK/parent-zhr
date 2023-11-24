package com.zhr.selfstudy.date.joda;

import com.zhr.selfstudy.PrintDiy;
import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;
import java.util.Locale;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DateTimeDemo
 * @Date 2019-10-21 11:04
 * @description <dependency>
 * <groupId>joda-time</groupId>
 * <artifactId>joda-time</artifactId>
 * <version>2.10.2</version>
 * </dependency>
 * <p>
 * Instant：不可变类，代表时间线上的一个瞬时的时间点
 * DateTime：不可变类，它以毫秒级的精度封装时间上的某个瞬间时刻，用来替换JDK的Calendar类
 * LocalDate：不可变类，该类封装了一个年/月/日的组合。没有时区信息
 * LocalTime：不可变类，表示一个本地的时间，而不包含日期部分。没有时区信息
 * LocalDateTime：不可变类，该类封装了一个年/月/日 时：分：秒的组合。没有时区信息
 **/
public class JodaDateTimeDemo {

    public static void main(String[] args) {
        // 构造一个DateTime实例
//        DateTime dt = new DateTime();
        DateTime dt = new DateTime(new Date());
        // 创建指定日期时间如：2017-11-27 14：30：50：500
//        DateTime dt = new DateTime(2017, 11, 27, 14, 30, 50, 500);

        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));

        System.out.println("***********************解析文本格式时间**********************");
        DateTimeFormatter format = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        DateTime dateTime = DateTime.parse("2015-12-21 23:22:45", format);
        System.out.println(dateTime.toString("yyyy/MM/dd HH:mm:ss EE"));

        System.out.println("***********************获取时间参数**********************");
        // with开头的方法（比如：withYear）：用来设置DateTime实例的某个时间。因为DateTime是不可变对象，所以没有提供setter方法可供使用，with方法也没有改变原有的对象，而是返回了设置后的一个副本对象。
        // plus/minus开头的方法（比如：plusDay, minusMonths）：用来返回在DateTime实例上增加或减少一段时间后的实例。
        // 返回Property的方法：Property是DateTime中的属性，保存了一些有用的信息。
        dt = dt.withYear(2017);// 设置年份为2017
        System.out.println(dt);

        int year = dt.getYear();// 年
        int month = dt.getMonthOfYear();// 月
        int day = dt.getDayOfMonth();// 日
        int hour = dt.getHourOfDay();// 小时
        int minute = dt.getMinuteOfHour();// 分钟
        int second = dt.getSecondOfMinute();// 秒
        int millis = dt.getMillisOfSecond();// 毫秒
        System.out.println(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + ":" + millis);

        String month2 = dt.monthOfYear().getAsText();
        String day2 = dt.dayOfWeek().getAsShortText();
        String day3 = dt.dayOfWeek().getAsShortText(Locale.CHINESE); // 以指定格式获取
        System.out.println(month2);
        System.out.println(day2);
        System.out.println(day3);

        System.out.println("********************时间计算*************************");
        dt = dt.plusDays(1);// 加一天
        dt = dt.plusHours(1);// 加一小时
        dt = dt.plusYears(-1);// 减一年
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));

        dt = dt.minusYears(1);// 减一年
        dt = dt.minusMinutes(-30);// 加半个小时
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));

        System.out.println("********************日期比较*************************");
        DateTime d1 = new DateTime("2015-10-01");
        DateTime d2 = new DateTime("2016-02-01");
        // 和系统时间比
        boolean b1 = d1.isAfterNow();
        boolean b2 = d1.isBeforeNow();
        boolean b3 = d1.isEqualNow();

        // 和其他日期比
        boolean f1 = d1.isAfter(d2);
        boolean f2 = d1.isBefore(d2);
        boolean f3 = d1.isEqual(d2);

        PrintDiy.printSign("计算间隔和区间");
        DateTime begin = new DateTime("2012-03-01");
        DateTime end = new DateTime("2023-09-05");
        //计算区间毫秒数
//        Duration d = new Duration(begin, end);
//        long millis2 = d.getMillis();

        //计算区间天数
        Period p = new Period(begin, end, PeriodType.days());
        int days = p.getDays();
        System.out.println("区间天数一共days = " + days);

        Period p2 = new Period(begin, end, PeriodType.years());
        int years = p2.getYears();
        System.out.println("区间天数一共years = " + years);

        //计算特定日期是否在该区间内
        Interval interval = new Interval(begin, end);
        boolean contained = interval.contains(new DateTime("2015-03-01"));
        System.out.println("contained = " + contained);

        PrintDiy.printSign("时区");
        DateTimeZone.setDefault(DateTimeZone.forID("Asia/Tokyo"));
        DateTime dt1 = new DateTime();
        System.out.println(dt1.toString("yyyy-MM-dd HH:mm:ss"));

        //伦敦时间
        DateTime dt2 = new DateTime(DateTimeZone.forID("Europe/London"));
        System.out.println(dt2.toString("yyyy-MM-dd HH:mm:ss"));

        PrintDiy.printSign("距新年还有多少天");
        LocalDate localDate = new LocalDate(new Date());
        LocalDate newYear = localDate.plusYears(1).withDayOfYear(1);
        Days days1 = Days.daysBetween(localDate, newYear);
        System.out.println("days1 = " + days1.getDays());
    }
}
