package completable;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author zhangjing710
 * @description 多线程并发执行取结果集合
 * @date 2022/2/24 8:41 下午
 */
public class ListenableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // 创建一个由invoke线程执行的线程池
        ListeningExecutorService executorService = MoreExecutors.newDirectExecutorService();
        // 装饰自定义的线程池返回
//        ListeningExecutorService executorService1 = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool());

        ListenableFuture<Integer> future1 = executorService.submit(() -> 1 + 2);
        ListenableFuture<Integer> future2 = executorService.submit(() -> Integer.parseInt("3q"));
        ListenableFuture<List<Object>> futures;
        futures = Futures.successfulAsList(future1, future2);

        Futures.addCallback(futures, new FutureCallback<List<Object>>() {
            @Override
            public void onSuccess(@Nullable List<Object> result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        }, executorService);

    }
}
