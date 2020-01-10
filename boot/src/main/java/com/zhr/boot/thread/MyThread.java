package com.zhr.boot.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyThread
 * @Date 2019-12-30 11:12
 * @description 实现Callable
 **/
public class MyThread implements Callable {

    private static Logger log = LoggerFactory.getLogger(MyThread.class);

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
//        System.out.println("业务执行完毕******************");
        log.info(Thread.currentThread() + ":业务执行完毕******************");
        return "success";
    }
}
