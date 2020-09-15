package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrCompareTest
 * @Date 2020-07-21 14:10
 * @description 一些字符串比较问题
 **/
public class StrCompareTest {

    public static void main(String[] args) {
        // 此行代码创建了两个对象，在执行前会在常量池中创建一个"1"的对象，然后执行该行代码时new一个"1"的对象存放在堆区中；
        // 然后str1指向堆区中的对象
        String str1 = new String("1");
        // 没有返回值接收,等于没啥作用,str1还是指向堆中的
        str1.intern();
        // 指向常量池中的对象
        String str2 = "1";
        System.out.println(str1 == str2);  // false

        String str11 = new String("1");
        // 有返回值接收,str11改变指向,指向了常量池中对象
        str11 = str11.intern();
        // 指向常量池中的对象
        String str22 = "1";
        System.out.println(str11 == str22);  // true

        // 首先使用StringBuffer的append方法将"2"和"2"拼接在一块，然后调用toString方法new出“22”；
        // 所以此时的“22”字符串是创建在堆区的
        String str3 = new String("2") + new String("2");
        // 没有返回值接收,等于没啥作用,str3还是指向堆中的
        str3.intern();
        // 指向堆区
        String str4 = "22";
        System.out.println(str3 == str4); // true
    }
}
