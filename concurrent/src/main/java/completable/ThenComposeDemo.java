package completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhangjing710
 * @description thenCompose - 任务完成则运行fn，依赖上一个任务的结果，有返回值
 * 类似thenApply（区别是thenCompose的返回值是CompletionStage，thenApply则是返回 U），提供该方法为了和其他CompletableFuture任务更好地配套组合使用
 * @date 2022/2/24 9:57 上午
 */
public class ThenComposeDemo {

    public static void main(String[] args) {
        //第一个异步任务，常量任务
        CompletableFuture<String> f = CompletableFuture.completedFuture("OK");
        //第二个异步任务
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "hello world", executor)
                .thenComposeAsync(data -> {
                    System.out.println(data);
                    return f; //使用第一个任务作为返回
                }, executor);
        System.out.println(future.join());
        executor.shutdown();
    }
}
