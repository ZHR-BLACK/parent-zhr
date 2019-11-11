package com.zhr.selfstudy.bigdecimal;

import java.math.BigDecimal;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveZero
 * @Date 2019-10-17 16:12
 * 去掉BigDecimal后无用的零
 **/
public class RemoveZero {

    public static void main(String[] args) {
        BigDecimal bd = new BigDecimal("56.100000000");
        System.out.println(bd.stripTrailingZeros().toPlainString());// 56.1
    }
}
