package com.zhr.selfstudy.hutool.StrBuilder;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.TimeInterval;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.StrBuilder;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrBuilderTest
 * @Date 2019-06-28 10:33
 * 测试StrBuilder和StringBuilder构建字符串的性能
 * 字符串拼接性能
 **/
public class StrBuilderTest {

    public static void main(String[] args) {
        //StringBuilder
        TimeInterval timer = DateUtil.timer();
        StringBuilder b2 = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            b2.append("test");
            b2 = new StringBuilder();
        }
        Console.log(timer.interval());


        //StrBuilder,拼接速度比上面StringBuilder拼接快一倍
        TimeInterval timer2 = DateUtil.timer();
        StrBuilder builder = StrBuilder.create();
        for (int i = 0; i < 1000000; i++) {
            builder.append("test");
            builder.reset();
        }
        Console.log(timer2.interval());

    }

}
