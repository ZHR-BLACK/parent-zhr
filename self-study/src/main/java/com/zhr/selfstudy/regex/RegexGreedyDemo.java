package com.zhr.selfstudy.regex;

import com.zhr.selfstudy.PrintDiy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RegexGreedyDemo
 * @Date 2019-10-21 15:38
 * @description 贪婪和懒惰模式
 **/
public class RegexGreedyDemo {

    public static void main(String[] args) {
        // 贪婪匹配：当正则表达式中包含能接受重复的限定符时，通常的行为是（在使整个表达式能得到匹配的前提下）匹配尽可能多的字符，这匹配方式叫做贪婪匹配。
        // 特性：一次性读入整个字符串进行匹配，每当不匹配就舍弃最右边一个字符，继续匹配，依次匹配和舍弃（这种匹配-舍弃的方式也叫做回溯），
        // 直到匹配成功或者把整个字符串舍弃完为止，因此它是一种最大化的数据返回，能多不会少。

        PrintDiy.printSign("贪婪匹配");
        // 匹配3到6位数字
        String reg = "\\d{3,6}";
        String test = "61762828 176 2991 871";
        System.out.println("文本：" + test);
        System.out.println("贪婪模式：" + reg);
        Pattern p1 = Pattern.compile(reg);
        Matcher m1 = p1.matcher(test);
        while (m1.find()) {
            System.out.println("匹配结果：" + m1.group(0));
        }

        PrintDiy.printSign("多个贪婪匹配");
        // 多个贪婪在一起时，如果字符串能满足他们各自最大程度的匹配时，就互不干扰，但如果不能满足时，会根据深度优先原则，
        // 也就是从左到右的每一个贪婪量词，优先最大数量的满足，剩余再分配下一个量词匹配。
        String reg2 = "(\\d{1,2})(\\d{3,4})";
        String test2 = "61762828 176 2991 87321";
        System.out.println("文本：" + test2);
        System.out.println("贪婪模式：" + reg2);
        Pattern p2 = Pattern.compile(reg);
        Matcher m2 = p2.matcher(test);
        while (m2.find()) {
            System.out.println("匹配结果：" + m2.group(0));
        }

        PrintDiy.printSign("懒惰模式");
        // 懒惰（非贪婪）
        //懒惰匹配：当正则表达式中包含能接受重复的限定符时，通常的行为是（在使整个表达式能得到匹配的前提下）匹配尽可能少的字符，这匹配方式叫做懒惰匹配。
        //特性：从左到右，从字符串的最左边开始匹配，每次试图不读入字符匹配，匹配成功，则完成匹配，否则读入一个字符再匹配，
        // 依此循环（读入字符、匹配）直到匹配成功或者把字符串的字符匹配完为止。
        // 懒惰量词是在贪婪量词后面加个“？”
        // 代码	    说明
        // *?	    重复任意次，但尽可能少重复
        // +?	    重复1次或更多次，但尽可能少重复
        // ??	    重复0次或1次，但尽可能少重复
        // {n,m}?	重复n到m次，但尽可能少重复
        // {n,}?	重复n次以上，但尽可能少重复
        String reg3 = "(\\d{1,2}?)(\\d{3,4})";
        String test3 = "61762828 176 2991 87321";
        System.out.println("文本：" + test3);
        System.out.println("贪婪模式：" + reg3);
        Pattern p3 = Pattern.compile(reg3);
        Matcher m3 = p3.matcher(test3);
        while (m3.find()) {
            System.out.println("匹配结果：" + m3.group(0));
        }


    }
}
