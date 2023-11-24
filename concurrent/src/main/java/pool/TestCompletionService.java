package pool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TestCompletionService
 * @Date 2020-09-14 16:52
 * @description CompletionService
 * 向CompletionService中提交10个Task,当Task有任务返回则会优先从CompletionService内部的队列中获取到Task的Future
 **/
public class TestCompletionService {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        //开启5个线程
        ExecutorService exs = Executors.newFixedThreadPool(5);
        try {
            int taskCount = 10;
            // 结果集
            List<Integer> list = new ArrayList<>();
//            List<Future<Integer>> futureList = new ArrayList<>();
            // 1.定义CompletionService
            CompletionService<Integer> completionService = new ExecutorCompletionService<>(exs);
            // 2.添加任务
            for (int i = 0; i < taskCount; i++) {
                completionService.submit(new Task(i + 1));
//                futureList.add(future);
            }
            // 3.获取结果
            for (int i = 0; i < taskCount; i++) {
                Integer result = completionService.take().get();
                System.out.println("任务i==" + result + "完成!" + new Date());
                list.add(result);
            }
            System.out.println("list=" + list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭线程池
            exs.shutdown();
        }
    }

    static class Task implements Callable<Integer> {
        Integer i;

        public Task(Integer i) {
            super();
            this.i = i;
        }
        @Override
        public Integer call() throws Exception {
            if (i == 5) {
                Thread.sleep(5000);
            } else {
                Thread.sleep(1000);
            }
            System.out.println("线程：" + Thread.currentThread().getName() + "任务i=" + i + ",执行完成！");
            return i;
        }
    }

}
