package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName IntCompareTest
 * @Date 2020-07-21 14:23
 * @description 涉及int相关的比较
 **/
public class IntCompareTest {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);// true
        System.out.println(e == f); // false
        // ==两边有算术运算，会进行拆箱，因此此时比较的是数值，而并非对象
        System.out.println(c == (a + b));// true
        // c与a+b的数值相等
        System.out.println(c.equals(a + b));// true
        // ==两边有算术运算，会进行拆箱，因此此时比较的是数值，而并非对象
        System.out.println(g == (a + b));// true
        // Long类型的equal在比较是时候，会先判断a+b是否为Long类型，显然a+b不是
        System.out.println(g.equals(a + b));// false
    }
}
