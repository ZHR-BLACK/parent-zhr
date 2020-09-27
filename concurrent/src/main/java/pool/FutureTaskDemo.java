package pool;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FutureTaskDemo
 * @Date 2020-09-23 17:13
 * @description FutureTask应用
 * 单线程阻塞
 **/
public class FutureTaskDemo {

    public static void main(String[] args){
        FutureTask<Integer> ft = new FutureTask<>(() -> {
            int num = new Random().nextInt(4);
            TimeUnit.SECONDS.sleep(num);
            return num;
        });
        Thread t = new Thread(ft);
        t.start();
        //这里可以做一些其它的事情，跟futureTask任务并行，等需要futureTask的运行结果时，可以调用get方法获取
        try {
            //等待任务执行完成，获取返回值
            Integer num = ft.get();
            System.out.println(num);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕==================");
    }

}
