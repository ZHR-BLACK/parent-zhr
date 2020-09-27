package com.zhr.selfstudy.classload;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestInit
 * @Date 2020-05-19 14:09
 * @description 测试加载顺序
 **/
public class TestInit {

    public static final String param = "yyy";

    static {
        System.out.println("父类静态代码块" + param);
    }

    {
        System.out.println("父类普通代码块" + param);
    }

    static void a() {
        System.out.println("父类静态方法");
    }

    public TestInit() {
        System.out.println("父类无参构造" + param);
    }

    public void b() {
        System.out.println("父类普通方法");
    }
}
