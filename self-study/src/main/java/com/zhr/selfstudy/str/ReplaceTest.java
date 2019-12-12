package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestReplace
 * @Date 2019-10-18 13:48
 * 测试String replace的用法
 **/
public class ReplaceTest {

    public static void main(String[] args) {

        String aa = "zhang000jing";
        // 这样是没替换掉的
        aa.replace("000", "222");
        System.out.println("aa = " + aa);// zhang000jing

        // 这样才算替换掉了,因为aa是String,不可变的,所以要用一个新的字符串来接收被替换后的字符串
        String replace = aa.replace("000", "222");
        System.out.println("replace = " + replace); // zhang222jing

    }
}
