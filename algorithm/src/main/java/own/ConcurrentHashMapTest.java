package own;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ConcurrentHashMapTest
 * @Date 2020-11-17 10:34
 * @description 多线程操作ConcurrentHashMap,不安全
 **/
public class ConcurrentHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        String key = "key";
        Map<String, Integer> hashMap = new ConcurrentHashMap<>();
        hashMap.put(key, 0);
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                Integer value = hashMap.get(key);

                hashMap.put(key, value + 1);
            }
            countDownLatch.countDown();
        };
        // 两个线程操作同一个key，可能会出现覆盖的现象
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();

        countDownLatch.await();
        System.out.println(hashMap);
    }
}
