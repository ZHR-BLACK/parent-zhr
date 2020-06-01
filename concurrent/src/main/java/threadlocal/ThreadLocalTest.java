package threadlocal;

import cn.hutool.core.util.RandomUtil;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadLocalTest
 * @Date 2020-05-29 17:57
 * @description ThreadLocal使用
 **/
public class ThreadLocalTest {

    /*定义一个全局变量 来存放线程需要的变量*/
    public static ThreadLocal<Integer> ti = new ThreadLocal<>();

    public static void main(String[] args) {
        /*创建两个线程*/
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                /*存入当前线程独有的值*/
                ti.set(RandomUtil.randomInt(5));
                new A().get();
                new B().get();
            }).start();
        }
    }

    static class A {
        public void get() {
            /*取得当前线程所需要的值*/
            System.out.println(ti.get());
        }
    }

    static class B {
        public void get() {
            /*取得当前线程所需要的值*/
            System.out.println(ti.get());
        }
    }
}
