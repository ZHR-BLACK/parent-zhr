package unsafe;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AtomicLongDemo
 * @Date 2019-07-26 18:22
 * AtomicLong
 *
 * 使用CAS非阻塞算法，性能更好。但是在高并发情况下AtomicLong还会存在性能问题
 **/
public class AtomicLongDemo {

    private static AtomicLong atomicLong = new AtomicLong();
    private static Integer[] arrOne = {0, 5, 6, 4, 8, 0, 7};
    private static Integer[] arrTwo = {0, 5, 7, 4, 8, 0, 7, 0};

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < arrOne.length; i++) {
                if (arrOne[i] == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < arrTwo.length; i++) {
                if (arrTwo[i] == 0) {
                    atomicLong.incrementAndGet();
                }
            }
        });
        thread.start();
        thread2.start();

        // 等待线程执行完毕
        thread.join();
        thread2.join();

        System.out.println("count = " + atomicLong.get());

    }
}
