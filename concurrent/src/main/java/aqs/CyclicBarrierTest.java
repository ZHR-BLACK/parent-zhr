package aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CyclicBarrierTest
 * @Date 2020-07-21 15:59
 * @description CyclicBarrier测试demo
 **/
public class CyclicBarrierTest {

    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        // 线程池
        ExecutorService exec = Executors.newCachedThreadPool();

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, () -> System.out.println("到齐5个了=================="));

        // 模拟50个客户端访问
        for (int index = 0; index < 50; index++) {
            Runnable run = () -> {
                try {
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "到了!");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            };
            exec.execute(run);
        }
        // 退出线程池
        exec.shutdown();
    }
}
