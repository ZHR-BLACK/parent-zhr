package pool;

import java.util.concurrent.*;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CountExample
 * @Date 2019-07-30 16:11
 * 利用Semaphore和CountDownLatch模拟高并发
 **/
public class CountExample {

    // 请求总数
    public static int clientTotal = 5000;
    // 同时并发执行的线程数
    public static int threadTotal = 300;

    public static int count = 0;

    public static int notSafeCount = 0;

    private static volatile CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws Exception {
        // 执行1000次累加5000的操作
        for (int i = 0; i < 100; i++) {
            bingfa();
        }
        System.out.println("notSafeCount = " + notSafeCount);
    }

    private static void bingfa() throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        //信号量，此处用于控制并发的线程数
        final Semaphore semaphore = new Semaphore(threadTotal);
        //闭锁，可实现计数器递减
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    //执行此方法用于获取执行许可，当总计未释放的许可数不超过200时，
                    //允许通行，否则线程阻塞等待，直到获取到许可。
                    semaphore.acquire();
                    // todo 这里比较的是这两种添加元素的方法的安全性
                    add();
//                    copyList();

                    //释放许可
                    semaphore.release();
                } catch (Exception e) {
                    //log.error("exception", e);
                    e.printStackTrace();
                } finally {
                    //闭锁减一
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();//线程阻塞，直到闭锁值为0时，阻塞才释放，继续往下执行
        executorService.shutdown();
        // todo 统计是否安全的计数器
        System.out.println("count:" + count);
        if (count != 5000) {
            notSafeCount++;
        }
        count = 0;

//        if(arrayList.size() != 5000){
//            notSafeCount++;
//        }
//        System.out.println("size = " + arrayList.size());
//        arrayList.clear();
    }

    // 待并发测试的方法,count++不是原子操作,不安全
    private static void add() {
        count++;
    }

    // 待并发测试的方法,arrayList是线程安全的
    private static void copyList() {
        arrayList.add("1");
    }
}
