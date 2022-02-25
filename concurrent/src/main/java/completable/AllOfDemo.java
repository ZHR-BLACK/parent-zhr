package completable;

import java.util.concurrent.CompletableFuture;

/**
 * @author zhangjing710
 * @description 多任务组合
 * @date 2022/2/24 10:52 上午
 */
public class AllOfDemo {

    public static void main(String[] args) {
        CompletableFuture<Void> future = CompletableFuture
                .allOf(CompletableFuture.completedFuture("A"),
                        CompletableFuture.completedFuture("B"));
        //全部任务都需要执行完
        future.join();

        CompletableFuture<Object> future2 = CompletableFuture
                .anyOf(CompletableFuture.completedFuture("C"),
                        CompletableFuture.completedFuture("D"));
        //其中一个任务行完即可
        future2.join();
    }
}
