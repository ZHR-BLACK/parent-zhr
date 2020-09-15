package thread;

import java.util.concurrent.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestCompletionService
 * @Date 2020-06-02 11:56
 * @description CompletionService是java1.8之前最好用的方法，
 * 能够实现按照任务完成的先后顺序获取任务的结果。
 * CompletionService方法可以通过completionService.take().get()方法获取最快完成的线程的返回结果
 * （若当前没有线程执行完成则阻塞直到最快的线程执行结束），第二次调用则返回第二快完成的线程的返回结果。
 **/
public class TestCompletionService {

    private static final String commandstr01 = "hahah";
    private static final String commandstr02 = "hahah";

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1、创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < 10; i++) {
            completionService.submit(new MyThreadt44(commandstr01));
        }
        for (int i = 0; i < 10; i++) {
            completionService.take().get();
        }
//        completionService.submit(new MyThreadt33(commandstr01));
//        completionService.submit(new MyThreadt44(commandstr01));
//        System.out.println(completionService.take().get());
//        System.out.println(completionService.take().get());
        System.out.println("释放开********************");
        executorService.shutdown();
//        System.out.println(completionService.take().get());
    }
}

class MyThreadt33 implements Callable<String> {
    private String commandstr;          // 要运行的mingling

    public MyThreadt33(String commandstr) {
        this.commandstr = commandstr;
    }

    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            Thread.sleep(200);
            sum += i;
            System.out.println("Mythread3:" + i);
        }
        return String.valueOf(sum + 300000);
    }
}

class MyThreadt44 implements Callable<String> {
    private String commandstr;          // 要运行的mingling

    public MyThreadt44(String commandstr) {
        this.commandstr = commandstr;
    }

    @Override
    public String call() throws Exception {
//        int sum = 0;
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(200);
//            sum += i;
//            System.out.println("Mythread4: " + i);
//        }
//        return String.valueOf(sum + 400000);
        System.out.println("commandstr********************" + commandstr);
        Thread.sleep(1000);
        return "success";
    }
}
