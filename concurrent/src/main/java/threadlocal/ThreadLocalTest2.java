package threadlocal;

import cn.hutool.core.util.RandomUtil;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadLocalTest2
 * @Date 2020-05-29 18:09
 * @description ThreadLocal使用
 **/
public class ThreadLocalTest2 {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                ThreadLocalDemo.getThreadInstance().setName("name:" + RandomUtil.randomString(5));
                new A().get();
                new B().get();
            }).start();
        }
//        Thread.sleep(1000);
//        new A().get();
    }
    static class A {
        public void get() {
            System.out.println(ThreadLocalDemo.getThreadInstance().getName());
        }
    }
    static class B {
        public void get() {
            System.out.println(ThreadLocalDemo.getThreadInstance().getName());
        }
    }

}
