package unsafe;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LongIncrementDemo
 * @Date 2019/6/13 11:15
 * 测试long count计数的不安全性
 **/
public class LongIncrementDemo {

    // 这里不管加不加volatile,结果都是不准的，计数结果不是期望的100000，而是要少一些，因为valotile不保证count++的原子性。
    private volatile long count = 0;
    private static CountDownLatch cdladdr = new CountDownLatch(100000);

    @Test
    public void testLong() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(10);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            exe.submit(() -> {
                // 不具备原子性
                count++;
                cdladdr.countDown();
            });
        }
        cdladdr.await();
        exe.shutdown();

        // 这里统计的总数不是期望的100000，实际要少
        System.out.println("count = " + count);
        System.out.println("LongAdderThread total spend:" + (System.currentTimeMillis() - starttime) + "ms");
    }

}
