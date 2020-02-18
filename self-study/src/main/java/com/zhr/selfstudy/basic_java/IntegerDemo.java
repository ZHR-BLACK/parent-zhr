package com.zhr.selfstudy.basic_java;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IntegerDemo
 * @Date 2019-12-10 11:58
 * @description Integer缓存池（IntegerCache）及整型缓存池
 * Integer中有个静态内部类IntegerCache，里面有个cache[],也就是Integer常量池，常量池的大小为一个字节（-128~127）
 **/
public class IntegerDemo {

    public static void main(String[] args) {
        int i = 10;
        int i1 = 10;
        Integer in1 = 10;
        Integer in2 = 10;
        Integer in3 = new Integer(10);
        Integer in4 = new Integer(10);
        Integer in5 = 199;
        Integer in6 = 199;

        System.out.println(i == i1);         // true
        System.out.println(i == in1);        // true
        System.out.println(i == in2);        // true
        System.out.println(i == in3);        // true

        System.out.println(in1 == in2);        // true
        System.out.println(in5 == in6);        // false

        System.out.println(in1 == in3);        // false

        System.out.println(in3 == in4);        // false

        Integer j1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);

        System.out.println("i1=i2 \t" + (j1 == i2));// true
        System.out.println("i1=i2+i3 \t" + (j1 == i2 + i3));// true
        System.out.println("i4=i5 \t" + (i4 == i5));// false
        System.out.println("i4=i5+i6 \t" + (i4 == i5 + i6));// true
    }
}
