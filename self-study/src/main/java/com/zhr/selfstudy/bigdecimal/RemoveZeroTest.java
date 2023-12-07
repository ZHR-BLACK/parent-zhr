package com.zhr.selfstudy.bigdecimal;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveZero
 * @Date 2019-10-17 16:12
 * 去掉数字型字符串后面无用的0
 * 去掉BigDecimal后无用的0
 **/
public class RemoveZeroTest {

    @Test
    public void stripZeroTest(){
        BigDecimal bd = new BigDecimal("56.100000000");
        System.out.println(bd.stripTrailingZeros().toPlainString());// 56.1
    }

}
