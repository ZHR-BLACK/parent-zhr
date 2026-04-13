package pool;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FutureTaskDemo
 * @Date 2020-09-23 17:13
 * @description FutureTask 应用示例
 * 
 * FutureTask 同时实现了 Runnable 和 Future 接口，既可以通过线程执行，
 * 也可以获取异步任务的执行结果。
 * 
 * 使用场景：
 * - 需要在主线程中获取子线程的计算结果
 * - 可以先做其他事情，最后通过 get() 方法获取结果
 * - 支持取消任务、查询任务状态等功能
 */
public class FutureTaskDemo {

    /** 随机数最大值（不包含） */
    private static final int MAX_RANDOM = 4;
    /** 获取Future结果的最大超时时间（秒） */
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        // 创建 FutureTask，包装一个 Callable 任务
        FutureTask<Integer> futureTask = new FutureTask<>(new CallableTask());
        
        // 创建并启动线程执行 FutureTask
        Thread thread = new Thread(futureTask);
        thread.start();
        
        // 主线程可以做一些其他事情，与 FutureTask 任务并行执行
        System.out.println("主线程继续执行其他任务...");
        doOtherWork();
        
        try {
            // 获取任务执行结果，会阻塞直到任务完成
            Integer result = futureTask.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
            System.out.println("任务执行结果: " + result);
        } catch (TimeoutException e) {
            System.err.println("任务执行超时");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("线程被中断");
        } catch (ExecutionException e) {
            System.err.println("任务执行异常: " + e.getCause());
        }
        
        System.out.println("执行完毕==================");
    }

    /**
     * 模拟主线程做的其他工作
     */
    private static void doOtherWork() {
        try {
            TimeUnit.MILLISECONDS.sleep(500);
            System.out.println("其他工作处理完成");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 可调用任务类
     * 模拟一个耗时计算任务
     */
    static class CallableTask implements Callable<Integer> {
        
        @Override
        public Integer call() throws Exception {
            // 生成随机休眠时间，模拟任务执行耗时
            int sleepTime = new Random().nextInt(MAX_RANDOM);
            System.out.println("任务开始执行，预计耗时: " + sleepTime + " 秒");
            
            // 模拟耗时操作
            TimeUnit.SECONDS.sleep(sleepTime);
            
            System.out.println("任务执行完成");
            return sleepTime;
        }
    }
}
