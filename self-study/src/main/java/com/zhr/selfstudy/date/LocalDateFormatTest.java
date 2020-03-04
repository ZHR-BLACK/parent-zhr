package com.zhr.selfstudy.date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LocalDateFormatTest
 * @Date 2019-10-21 10:53
 * @description 日期格式化
 **/
public class LocalDateFormatTest {

    // DateTimeFormatter默认提供了多种格式化方式，如果默认提供的不能满足要求，
    // 可以通过DateTimeFormatter的ofPattern方法创建自定义格式化方式
    public static void main(String[] args) {
        LocalDate localDate = LocalDate.of(2019, 9, 10);

        String s1 = localDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("s1 = " + s1);
        String s2 = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("s2 = " + s2);
        //自定义格式化
        DateTimeFormatter dateTimeFormatter =   DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String s3 = localDate.format(dateTimeFormatter);
        System.out.println("s3 = " + s3);

        // 解析时间
        LocalDate localDate1 = LocalDate.parse("20190910", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("localDate1 ********************" + localDate1);
        LocalDate localDate2 = LocalDate.parse("2019-09-10", DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("localDate2 ********************" + localDate2);

    }
}
