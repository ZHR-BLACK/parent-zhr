package com.zhr.selfstudy.regex;

import com.zhr.selfstudy.PrintDiy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RegexGroup2Demo
 * @Date 2019-10-21 15:29
 * @description todo
 **/
public class RegexGroup2Demo {

    public static void main(String[] args) {

        PrintDiy.printSign("捕获组应用1");
        // 查找一串字母"aabbbbgbddesddfiid"里成对的字母
        String test = "aabbbbgbddesddfiid";
        Pattern pattern = Pattern.compile("(\\w)\\1");
        Matcher mc = pattern.matcher(test);
        while (mc.find()) {
            System.out.println(mc.group());
        }

        PrintDiy.printSign("捕获组应用2");
        // 把字符串中abc换成a
        String test2 = "abcbbabcbcgbddesddfiid";
        String reg2 = "(a)(b)c";
        System.out.println(test2.replaceAll(reg2, "$1"));


    }
}
