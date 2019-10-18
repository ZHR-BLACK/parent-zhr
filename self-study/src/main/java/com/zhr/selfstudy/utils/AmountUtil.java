package com.zhr.selfstudy.utils;

import java.math.BigDecimal;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AmountUtil
 * @Date 2019-10-17 15:37
 * 金额相关
 **/
public class AmountUtil {

    // 金额元转为分
    public static String convert(String amount){
        long newLong = new BigDecimal(amount).multiply(new BigDecimal(100)).longValue();
        return String.valueOf(newLong);
    }
}
