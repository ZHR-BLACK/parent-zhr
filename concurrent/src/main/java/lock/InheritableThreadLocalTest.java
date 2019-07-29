package lock;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName InheritableThreadLocalTest
 * @Date 2019-07-26 15:11
 * InheritableThreadLocalTest
 **/
public class InheritableThreadLocalTest {

    // InheritableThreadLocal可以让子线程访问父线程设置的本地变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        // 主线程设置本地变量
        threadLocal.set("hello world");

        // 子线程
        Thread thread = new Thread(() -> {
            System.out.println("thread = " + threadLocal.get());
        });
        thread.start();

        System.out.println("main = " + threadLocal.get());
    }
}
