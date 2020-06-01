package com.zhr.selfstudy.init;

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
        System.out.println("111" + param);
    }

    static void a() {
        System.out.println("aaa");
    }

    public TestInit() {
        System.out.println("bbb" + param);
    }

    public void b() {
        System.out.println("eee");
    }
}
