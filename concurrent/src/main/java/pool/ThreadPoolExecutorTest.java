package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadPoolExecutorTest
 * @Date 2019-12-30 11:05
 * @description 自定义实现线程池
 * 自定义线程工厂
 * 自定义拒绝策略
 **/
public class ThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(500);
        ThreadFactory threadFactory = new NameTreadFactory();
        RejectedExecutionHandler rejectedExecutionHandler = new RejectProxy();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 5, 60, TimeUnit.SECONDS, workQueue, threadFactory, rejectedExecutionHandler);

        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            MyThread thread = new MyThread(i);
            try {
                Future<String> submit = pool.submit(thread);
                list.add(submit);
            } catch (Exception e) {
//                e.printStackTrace();
            }
        }
        System.out.println("list==================" + list.size());
        for (Future<String> stringFuture : list) {
            try {
                stringFuture.get();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
        System.out.println("执行完毕==================");
    }

    // 自定义拒绝策略
    static class RejectProxy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            try {
                System.out.println("重新加入队列中执行==================" + r);
                // 核心改造点，由blockingqueue的offer改成put阻塞方法
                executor.getQueue().put(r);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 自定义线程工厂
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
