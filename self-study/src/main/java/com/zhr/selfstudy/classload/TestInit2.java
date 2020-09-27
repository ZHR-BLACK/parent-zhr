package com.zhr.selfstudy.classload;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestInit2
 * @Date 2020-05-19 14:09
 * @description 测试加载顺序
 * 先初始化静态代码块和构造方法,先父类再子类
 * 静态代码块主要用于类的初始化。它只执行一次，并且在同属于一个类的main函数之前执行,主动执行
 * 静态方法项目启动的时候初始化,但不执行
 * 静态方法和实例方法是被动执行的
 **/
public class TestInit2 extends TestInit {

    public static final String param2 = "uuu";

    static {
        System.out.println("子类静态代码块" + param2);
    }

    {
        System.out.println("子类普通代码块" + param2);
    }

    static void a() {
        System.out.println("子类静态方法");
    }

    public TestInit2() {
        System.out.println("子类无参构造" + param2);
    }

    public void b() {
        System.out.println("子类普通方法");
    }

    public static void main(String[] args) {
        /**
         * 父类静态代码块yyy
         * 子类静态代码块uuu
         * 父类普通代码块yyy
         * 父类无参构造yyy
         * 子类普通代码块uuu
         * 子类无参构造uuu
         **/
        TestInit i = new TestInit2();
    }
}
