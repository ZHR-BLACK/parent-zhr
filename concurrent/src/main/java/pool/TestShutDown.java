package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestShutDown
 * @Date 2019/6/12 14:19
 * 使用完线程池后如果不调用shutdown关闭线程池，则会导致线程池资源一直不被释放。
 * JVM一直没退出
 **/
public class TestShutDown {

    static void asynExecuteOne() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            System.out.println("--async execute one---");
        });
        // 加上以下代码才会使线程池关闭
//        executor.shutdown();
    }

    static void asynExecuteTwo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            System.out.println("--async execute two---");
        });
        // 加上以下代码才会使线程池关闭
//        executor.shutdown();
    }


    public static void main(String[] args) {
        //(1)同步执行
        System.out.println("---sync execute---");
        //(2)异步执行操作one
        asynExecuteOne();
        //(3)异步执行操作two
        asynExecuteTwo();
        //(4)执行完毕
        System.out.println("---execute over---");

    }
}
