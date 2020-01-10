package pool;

import java.util.concurrent.Callable;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyThread
 * @Date 2019-12-30 11:12
 * @description 实现Callable
 **/
public class MyThread implements Callable {

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        System.out.println("业务执行完毕******************");
        return "success";
    }
}
