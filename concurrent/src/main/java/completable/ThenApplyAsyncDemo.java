package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangjing710
 * @description 串行执行
 * @date 2022/2/24 10:16 上午
 */
public class ThenApplyAsyncDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "hello world", executor)
                .thenApplyAsync(data -> {
                    // 任务完成则运行fn，依赖上一个任务的结果，有返回值
                    System.out.println(data);
                    return "OK";
                }, executor);
        System.out.println(future.join());
        executor.shutdown();
    }

}
