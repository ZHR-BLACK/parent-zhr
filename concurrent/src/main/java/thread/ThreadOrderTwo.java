package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadOrderTwo
 * @Date 2019-10-24 16:04
 * @description 三个线程顺序执行
 **/
public class ThreadOrderTwo {

    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run 1");
            }
        }, "T1");
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run 2");
            }
        }, "T2");
        Thread t3 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " run 3");
            }
        }, "T3");

        //三个线程顺序执行 第一种方案，单个线程池 顺序放入执行队列中
        ExecutorService executor = Executors.newSingleThreadExecutor();

        executor.submit(t3);
        executor.submit(t2);
        executor.submit(t1);
        executor.shutdown();
    }


}
