package com.zhr.selfstudy.basic_java;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CatchFinallyTest
 * @Date 2019-12-10 14:45
 * @description todo
 **/
public class CatchFinallyTest {

    public static void main(String[] args) {

        int a = a();
        System.out.println("a ********************" + a);
        int b = b();
        System.out.println("b ********************" + b);
    }

    // finally代码中最好不要包含return，程序会提前退出，也就是说返回的值不是try或catch中的值
    public static int a(){
        int a = 5;
        try {
            int b = 5/0;
        } catch (Exception e) {
            return a + 2;
        } finally {
            return a + 1;
        }
    }
    // finally是在return后面的表达式运算之后执行的，此时并没有返回运算之后的值，而是把值保存起来，
    // 不管finally对该值做任何的改变，返回的值都不会改变，依然返回保存起来的值。
    // 也就是说方法的返回值是在finally运算之前就确定了的
    public static int b(){
        int a = 5;
        try {
            int b = 5/0;
        } catch (Exception e) {
            return a + 2;
        } finally {
            a = a + 1;
        }
        return 0;
    }
}
