package aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SemaphoreTest
 * @Date 2020-07-21 15:33
 * @description Semaphore的小demo
 **/
public class SemaphoreTest {

    public static void main(String[] args) {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();
        // 最多只能5个线程同时访问
        final Semaphore semp = new Semaphore(5);
        // 模拟20个客户端访问
        for (int index = 0; index < 50; index++) {
            final int NO = index;
            Runnable run = () -> {
                try {
                    // 获取许可
                    semp.acquire();
                    System.out.println("Accessing: " + NO);
                    Thread.sleep((long) (Math.random() * 6000));
                    // 访问完后，释放
                    semp.release();
                    //availablePermits()指的是当前信号灯库中有多少个可以被使用
                    System.out.println("-----------------" + semp.availablePermits());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}
