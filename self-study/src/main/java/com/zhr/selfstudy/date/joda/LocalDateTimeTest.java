package com.zhr.selfstudy.date.joda;

import lombok.extern.slf4j.Slf4j;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LocalDateTimeTest
 * @Date 2019-10-21 10:45
 * @description 修改日期
 * localDateTime加减日期
 * LocalDateTime转Date
 **/
@Slf4j
public class LocalDateTimeTest {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("当前日期 ==================== " + localDateTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(2019, Month.SEPTEMBER, 10, 14, 46, 56);
        log.info("localDateTime1:{}", localDateTime1);
        //增加一年
        localDateTime = localDateTime.plusYears(1);
        localDateTime = localDateTime.plus(1, ChronoUnit.YEARS);
        log.info("增加一年 ===================== " + localDateTime);
        //减少一个月
        localDateTime = localDateTime.minusMonths(1);
        localDateTime = localDateTime.minus(1, ChronoUnit.MONTHS);
        log.info("减少一个月 ===================== " + localDateTime);

        //修改年为2019
        localDateTime = localDateTime.withYear(2019);
        log.info("修改2019 ===================== " + localDateTime);
        //修改为2022
        localDateTime = localDateTime.with(ChronoField.YEAR, 2022);
        log.info("修改2022 ===================== " + localDateTime);
        String format = localDateTime.format(DateTimeFormatter.BASIC_ISO_DATE);
        log.info("format = " + format);

        // LocalDateTime转Date
        Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        log.info("date = " + date);
    }

}
