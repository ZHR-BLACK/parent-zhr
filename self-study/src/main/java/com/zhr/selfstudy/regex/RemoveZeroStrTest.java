package com.zhr.selfstudy.regex;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RemoveZeroStrTest
 * @Date 2020-05-20 9:53
 * @description 去掉字符串前面的0
 **/
public class RemoveZeroStrTest {

    public static void main(String[] args) {
        String str = "000000001234034120";
        String newStr = str.replaceAll("^(0+)", "");
        System.out.println(newStr);
    }
}
