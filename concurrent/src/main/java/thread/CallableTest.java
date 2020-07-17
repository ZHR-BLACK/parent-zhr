package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CallableTest
 * @Date 2020-06-02 11:37
 * @description 测试Future的get方法阻塞
 *
 * submit有返回值，并且返回执行结果Future对象
 **/
public class CallableTest {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future submit = null;
        for (int i = 0; i < 10; i++) {
            submit = executorService.submit(new CallableDemo());
        }
        // 阻塞住
        System.out.println("阻塞********************");
        try {
            if (!submit.isDone()) {
                submit.get();
            }
            System.out.println("阻塞放开********************");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }
}

class CallableDemo implements Callable {
    @Override
    public Object call() throws Exception {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + ":********************");
        return null;
    }
}
