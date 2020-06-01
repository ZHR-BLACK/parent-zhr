package com.zhr.selfstudy.init;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestInit2
 * @Date 2020-05-19 14:09
 * @description 测试加载顺序
 *
 * 先初始化静态代码块和构造方法,先父类再子类
 * 静态代码块主要用于类的初始化。它只执行一次，并且在同属于一个类的main函数之前执行,主动执行
 * 静态方法项目启动的时候初始化,但不执行
 * 静态方法和实例方法是被动执行的
 **/
public class TestInit2 extends TestInit{

    public static final String param2 = "uuu";

    static {
        System.out.println("222" + param2);
    }

    static void a() {
        System.out.println("ccc");
    }

    public TestInit2() {
        System.out.println("ddd" + param2);
    }

    public void b() {
        System.out.println("fff");
    }

    public static void main(String[] args) {
        TestInit i = new TestInit2();
    }
}
