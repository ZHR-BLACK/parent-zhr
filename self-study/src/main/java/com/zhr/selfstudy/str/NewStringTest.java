package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName NewStringTest
 * @Date 2019-12-09 13:57
 * @description 对String和new String()进行比对
 **/
public class NewStringTest {

    public static void main(String[] args) {
        String s1 = new String("abc");
        String s2 = "abc";

        // 值相同
        System.out.println("=====================" + (s1.equals(s2)));// true
        // s1利用new 操作后，为该对象在堆（Heap）区分配了一块内存； s2是字符串常量，存放在内存的”字符串常量区“ ；
        // 虽然两个对象的值相同，但由于两者位于不同的地址，不是相同的对象
        System.out.println("======================" + (s1 == s2));// false
    }
}
