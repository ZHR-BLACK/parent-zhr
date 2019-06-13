package unsafe;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LongAdderDemo
 * @Date 2019/6/13 10:51
 * 测试LongAdder的计数
 **/
public class LongAdderDemo {

    private LongAdder lacount = new LongAdder();
    private static CountDownLatch cdladdr = new CountDownLatch(100000);

    @Test
    public void testLongAdder() throws InterruptedException {
        ExecutorService exe = Executors.newFixedThreadPool(100);
        long starttime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            exe.submit(() -> {
                lacount.increment();
                cdladdr.countDown();
            });
        }
        cdladdr.await();
        exe.shutdown();

        System.out.println("总数 = " + lacount.sum());
        System.out.println("总耗时 = " + (System.currentTimeMillis() - starttime) + "ms");
    }

}
