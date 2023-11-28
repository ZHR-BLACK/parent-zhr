package own;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreeThreadPrint3
 * @Date 2020-09-18 10:52
 * @description 一个线程交替顺序打印abc
 * 使用AtomicInteger
 **/
public class ThreeThreadPrint3 {

    private final static AtomicInteger count = new AtomicInteger(0);
    private final static int sum = 3 * 10;
    private final static String[] strs = {"A", "B", "C"};
    private static int type;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            while (true) {
                synchronized (ThreeThreadPrint3.class) {
                    if (count.get() < sum) {
                        type = count.get() % 3;
                        System.out.print(strs[type]);
                        count.getAndIncrement();
                    } else {
                        break;
                    }
                }
            }
        });
        thread.start();
    }
}
