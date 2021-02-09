package pool;

import lombok.extern.slf4j.Slf4j;
import poolparam.CustomRejectedPolicy;
import poolparam.CustomTreadFactory;
import poolparam.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @创建人 zhangjing710
 * @创建时间 2021/2/2 14:15
 * @描述 创建线程池
 */
@Slf4j
public class ThreadPoolUtil {

    public static String threadName = "default-thread-name";

    static BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(5000);
    static RejectedExecutionHandler rejectedPolicy = new CustomRejectedPolicy();
    static ThreadFactory factory = new CustomTreadFactory(threadName);
    public static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,
            30, 30, TimeUnit.SECONDS, queue, factory, rejectedPolicy);

    public static <T> List<T> addTask(List<Callable<T>> tasks) {
        List<Future<T>> futureList;
        List<T> results = null;
        try {
            futureList = threadPoolExecutor.invokeAll(tasks);
            results = new ArrayList<>();
            for (Future<T> future : futureList) {
                results.add(future.get(2, TimeUnit.SECONDS));
            }
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return results;
    }

    public static void main(String[] args) {
        List<Callable<List<String>>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            callables.add(new Task(i));
            log.info("i = " + i);
        }
        List<String> sumList = new ArrayList<>();
        List<List<String>> lists = addTask(callables);
        log.info("**********************");
        lists.forEach(sumList::addAll);
        log.info("lists = " + lists);
        log.info("sumList = " + sumList);
    }
}
