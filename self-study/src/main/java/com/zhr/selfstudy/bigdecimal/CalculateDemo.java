package com.zhr.selfstudy.bigdecimal;

import com.zhr.selfstudy.PrintDiy;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CalculateDemo
 * @Date 2019-11-04 10:54
 * @description BigDecimal的相关计算
 * 设定保留小数
 **/
@Slf4j
public class CalculateDemo {

    public static void main(String[] args) {
        PrintDiy.printSign("计算后四舍五入保留两位小数");
        BigDecimal bigDecimal = new BigDecimal("10.50").multiply(new BigDecimal("10.00")).setScale(2, RoundingMode.HALF_UP);
        log.info("bigDecimal:{}" , bigDecimal);//105.00

        PrintDiy.printSign("比较两数大小");
        boolean compare = compare("12.50", "36.50");
        log.info("compare:{}" , compare);// false

        PrintDiy.printSign("取余数,并设定小数位几位");
        BigDecimal remainder = remainder(new BigDecimal("20"), new BigDecimal("6"), 2);
        log.info("remainder:{}" , remainder);// 2.00
    }

    // 比较大小
    public static boolean compare(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        int bj = b1.compareTo(b2);
        boolean res;
        res = bj > 0;
        return res;
    }

    // 取余数,并设定小数位几位
    public static BigDecimal remainder(BigDecimal v1, BigDecimal v2, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        return v1.remainder(v2).setScale(scale, RoundingMode.HALF_UP);
    }


}
