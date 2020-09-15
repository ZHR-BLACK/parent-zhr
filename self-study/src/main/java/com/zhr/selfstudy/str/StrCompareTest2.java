package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrCompareTest2
 * @Date 2020-07-21 14:21
 * @description 一些字符串比较问题2
 **/
public class StrCompareTest2 {

    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "bbb";
        // 指向字符串常量池
        String str3 = "aaabbb";
        // 指向堆区
        String str4 = str1 + str2;
        // jvm对其有优化处理，也就是在编译阶段就会将这两个字符串常量进行拼接，也就是"aaabbb";所以他是在方法区中的
        String str5 = "aaa" + "bbb";
        System.out.println(str3 == str4); // false
        System.out.println(str3 == str4.intern()); // true
        System.out.println(str3 == str5);// true
    }
}
