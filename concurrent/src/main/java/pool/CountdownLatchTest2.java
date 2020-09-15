package pool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CountdownLatchTest2
 * @Date 2020-08-13 16:04
 * @description CountdownLatchTest测试
 **/
public class CountdownLatchTest2 {

    public static void main(String[] args){
        ExecutorService service = Executors.newCachedThreadPool(); //创建一个线程池
        final CountDownLatch count = new CountDownLatch(30);
        for (int i = 0; i < 30; i++) {
            Runnable runnable = () -> {
                try {
                    System.out.println("线程" + Thread.currentThread().getName() +
                            "正准备接受命令");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    count.countDown();
                }
            };
            service.execute(runnable);//为线程池加入任务
        }

        try {
            count.await();
            System.out.println("runnable==================");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            service.shutdown(); //任务结束。停止线程池的全部线程
        }
    }
}
