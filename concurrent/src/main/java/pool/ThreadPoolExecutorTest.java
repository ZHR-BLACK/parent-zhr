package pool;

import java.util.LinkedHashSet;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadPoolExecutorTest
 * @Date 2019-12-30 11:05
 * @description 自定义实现线程池
 **/
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(5);
        ThreadFactory threadFactory = new NameTreadFactory();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 10, 10, TimeUnit.SECONDS, workQueue, threadFactory);

        for (int i = 0; i < 10; i++) {
            MyThread thread = new MyThread();
            Future submit = pool.submit(thread);
            try {
                System.out.println("submit ********************" + submit.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
            System.out.println(t.getName() + " has been created");
            return t;
        }
    }
}
