package pool;

import java.util.concurrent.Callable;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MyThread
 * @Date 2019-12-30 11:12
 * @description 实现Callable
 **/
public class MyThread implements Callable<String> {

    private int i;

    public MyThread(int i){
        this.i = i;
    }
    @Override
    public String call() {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(Thread.currentThread() + ":业务执行完毕******************" + i);
        return "success";
    }
}
