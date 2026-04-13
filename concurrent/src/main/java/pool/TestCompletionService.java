package pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.time.LocalDateTime;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestCompletionService
 * @Date 2020-09-14 16:52
 * @description CompletionService 示例
 * 向CompletionService中提交10个Task，当Task有任务返回则会优先从CompletionService内部的队列中获取到Task的Future
 */
public class TestCompletionService {

    /** 线程池大小 */
    private static final int THREAD_POOL_SIZE = 5;
    /** 任务总数 */
    private static final int TASK_COUNT = 10;
    /** 获取Future结果的超时时间（秒） */
    private static final int TIMEOUT_SECONDS = 10;
    /** 慢任务休眠时间（毫秒）- 模拟耗时较长的任务 */
    private static final long SLOW_TASK_SLEEP_MS = 5000;
    /** 普通任务休眠时间（毫秒）- 模拟正常任务 */
    private static final long NORMAL_TASK_SLEEP_MS = 1000;

    public static void main(String[] args) {
        // 开始时间，用于计算总耗时
        long startTime = System.currentTimeMillis();
        // 固定大小线程池，用于执行任务
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        
        try {
            // 结果列表，存储已完成的任务结果
            List<Integer> resultList = new ArrayList<>();
            // CompletionService用于按完成顺序获取任务结果
            CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);

            // 提交所有任务
            for (int i = 0; i < TASK_COUNT; i++) {
                completionService.submit(new Task(i + 1));
            }

            // 按完成顺序获取结果
            for (int i = 0; i < TASK_COUNT; i++) {
                try {
                    // 获取已完成的Future对象
                    Future<Integer> future = completionService.take();
                    // 从Future中获取任务结果（带超时控制）
                    Integer result = future.get(TIMEOUT_SECONDS, TimeUnit.SECONDS);
                    System.out.printf("任务i==%d完成! %s%n", result, LocalDateTime.now());
                    resultList.add(result);
                } catch (TimeoutException e) {
                    System.err.println("任务执行超时");
                }
            }

            System.out.println("resultList=" + resultList);
            // 输出总耗时
            System.out.printf("总耗时: %d ms%n", System.currentTimeMillis() - startTime);

        } catch (InterruptedException e) {
            // 中断标志位恢复，响应中断
            Thread.currentThread().interrupt();
            System.err.println("线程被中断");
        } catch (ExecutionException e) {
            // 获取任务执行时的原始异常
            System.err.println("任务执行异常: " + e.getCause());
        } finally {
            // 优雅关闭线程池
            shutdownExecutor(executorService);
        }
    }

    /**
     * 优雅关闭线程池
     * @param executor 待关闭的线程池执行器
     */
    private static void shutdownExecutor(ExecutorService executor) {
        // 先尝试平滑关闭，不再接受新任务
        executor.shutdown();
        try {
            // 等待已提交任务完成，最多等待60秒
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                // 超时则强制关闭
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            // 等待过程中被中断，强制关闭并恢复中断标志
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    /**
     * 任务类
     */
    static class Task implements Callable<Integer> {
        // 任务编号
        private final Integer taskNumber;

        public Task(Integer taskNumber) {
            this.taskNumber = taskNumber;
        }

        @Override
        public Integer call() throws Exception {
            // 模拟不同任务执行时间：任务5执行5秒，其他任务执行1秒
            long sleepTime = (taskNumber == 5) ? SLOW_TASK_SLEEP_MS : NORMAL_TASK_SLEEP_MS;
            TimeUnit.MILLISECONDS.sleep(sleepTime);
            
            // 获取当前执行线程的名称
            String threadName = Thread.currentThread().getName();
            System.out.printf("线程：%s 任务i=%d, 执行完成！%n", threadName, taskNumber);
            
            // 返回任务编号作为执行结果
            return taskNumber;
        }
    }
}
