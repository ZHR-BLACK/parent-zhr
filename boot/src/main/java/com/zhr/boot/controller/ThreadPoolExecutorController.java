package com.zhr.boot.controller;

import com.zhr.boot.thread.MyThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ThreadPoolExecutorController
 * @Date 2019-12-30 14:38
 * @description 测试多个请求访问线程池逻辑时的情况
 **/
@RestController
public class ThreadPoolExecutorController {

    private static Logger log = LoggerFactory.getLogger(ThreadPoolExecutorController.class);


    @RequestMapping("/thread")
    public void index() {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
        ThreadFactory threadFactory = new NameTreadFactory();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 10, 30, TimeUnit.SECONDS, workQueue, threadFactory);

        for (int i = 0; i < 10; i++) {
            Future submit = pool.submit(new MyThread());
            // 加上如下代码后变为了单线程
//            try {
//                System.out.println("submit ********************" + submit.get());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (ExecutionException e) {
//                e.printStackTrace();
//            }
        }
        pool.shutdown();
    }


    static class NameTreadFactory implements ThreadFactory {
        private final AtomicInteger mThreadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, "my-thread-" + mThreadNum.getAndIncrement());
//            System.out.println(t.getName() + " has been created");
            log.info(t.getName() + " has been created");
            return t;
        }
    }

}
