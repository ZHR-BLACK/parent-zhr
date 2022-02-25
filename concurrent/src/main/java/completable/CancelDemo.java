package completable;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhangjing710
 * @description 取消执行线程任务
 * @date 2022/2/24 10:55 上午
 */
public class CancelDemo {

    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture
                .supplyAsync(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                    }
                    return "hello world";
                })
                .thenApply(data -> 1);

        System.out.println("任务取消前:" + future.isCancelled());
        // 如果任务未完成,则返回异常,需要对使用exceptionally，handle 对结果处理
        future.cancel(true);
        System.out.println("任务取消后:" + future.isCancelled());
        future = future.exceptionally(e -> {
            e.printStackTrace();
            return 0;
        });
        System.out.println(future.join());
    }
}
