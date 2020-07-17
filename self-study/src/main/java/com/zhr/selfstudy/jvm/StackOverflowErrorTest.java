package com.zhr.selfstudy.jvm;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StackOverflowErrorTest
 * @Date 2020-06-02 15:13
 * @description Exception in thread "main" java.lang.StackOverflowError
 * 	at com.zhr.selfstudy.jvm.StackOverflowErrorTest.m(StackOverflowErrorTest.java:17)
 *
 * 	递归调用
 **/
public class StackOverflowErrorTest {

    public static void main(String[] args) {
        m();
    }

    public static void m(){
        m();
    }
}
