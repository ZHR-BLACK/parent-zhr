package lock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadLocalTest
 * @Date 2019-07-26 14:50
 * ThreadLocal用法
 **/
public class ThreadLocalTest {

    static void print(String str) {
        System.out.println(str + " = " + local.get());
        // 清除当前线程本地内存中的local变量
        local.remove();
    }

    static ThreadLocal<String> local = new ThreadLocal<>();

    public static void main(String[] args) {
        Thread threadOne = new Thread(() -> {
            local.set("threadOne local variable");

            print("threadOne");

            System.out.println("threadOne remove after = " + local.get());
        });

        Thread threadTwo = new Thread(() -> {
            local.set("threadTwo local variable");

            print("threadTwo");

            System.out.println("threadTwo remove after = " + local.get());
        });

        threadOne.start();
        threadTwo.start();
    }


}
