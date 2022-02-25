package completable;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zhangjing710
 * @description FutureTask实现多线程并发执行任务并取结果归集
 * @date 2022/2/24 3:50 下午
 */
public class FutureTaskDemo2 {

    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        //开启多线程
        ExecutorService exs = Executors.newFixedThreadPool(10);
        try {
            //结果集
            List<Integer> list = new ArrayList<>();
            List<FutureTask<Integer>> futureList = new ArrayList<>();
            //启动线程池，10个任务固定线程数为5
            for (int i = 0; i < 10; i++) {
                FutureTask<Integer> futureTask = new FutureTask<>(new CallableTask(i + 1));
                //提交任务，添加返回，Runnable特性
                exs.submit(futureTask);
                //Future特性
                futureList.add(futureTask);
            }
            Long getResultStart = System.currentTimeMillis();
            System.out.println("结果归集开始时间=" + new Date());
            //结果归集
            while (futureList.size() > 0) {
                Iterator<FutureTask<Integer>> iterable = futureList.iterator();
                //遍历一遍
                while (iterable.hasNext()) {
                    Future<Integer> future = iterable.next();
                    if (future.isDone() && !future.isCancelled()) {
                        //Future特性
                        Integer i = future.get();
                        System.out.println("任务i=" + i + "获取完成，移出任务队列！" + new Date());
                        list.add(i);
                        //任务完成移除任务
                        iterable.remove();
                    } else {
                        //避免CPU高速轮循，可以休息一下。
                        Thread.sleep(1);
                    }
                }
            }
            System.out.println("list=" + list);
            System.out.println("总耗时=" + (System.currentTimeMillis() - start) + ",取结果归集耗时=" + (System.currentTimeMillis() - getResultStart));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            exs.shutdown();
        }
    }

    static class CallableTask implements Callable<Integer> {
        Integer i;

        public CallableTask(Integer i) {
            super();
            this.i = i;
        }
        @Override
        public Integer call() throws Exception {
            if (i == 1) {
                Thread.sleep(3000);//任务1耗时3秒
            } else if (i == 5) {
                Thread.sleep(5000);//任务5耗时5秒
            } else {
                Thread.sleep(1000);//其它任务耗时1秒
            }
            System.out.println("task线程：" + Thread.currentThread().getName() + "任务i=" + i + ",完成！" + new Date());
            return i;
        }
    }

}
