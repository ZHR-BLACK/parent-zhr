package pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadPoolLocalTest
 * @Date 2019-11-14 17:59
 * @description 测试ThreadLocal使用时不remove的话会内存泄漏
 **/
public class ThreadPoolLocalTest {

    static class LocalVariable {
        private Long[] a = new Long[1024 * 1024];
    }

    final static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>());

    final static ThreadLocal<LocalVariable> localVirable = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 50; i++) {
            poolExecutor.execute(() -> {
                localVirable.set(new LocalVariable());

                System.out.println("Use local variable********************");
                // 不加remove会内存泄漏
//                localVirable.remove();
            });
            Thread.sleep(1000);
        }

        System.out.println("pool executor over********************");
    }
}
