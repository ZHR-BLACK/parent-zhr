package com.zhr.selfstudy.redis.redisson;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBlockingDeque;
import org.redisson.api.RDelayedQueue;

import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @date 2023/11/29
 * @description 延迟队列
 * 延迟队列是指在队列中存储带有过期时间的数据，在过期时间到达时自动从队列中移除。
 * Redisson实现的延迟队列是基于Redis的zset命令实现的，通过将数据存储到zset中，并设置过期时间作为score，
 * 通过定时任务轮询zset来实现延迟队列的功能。
 */
@Slf4j
public class RedissonDelayedQueueTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    @Test
    public void delayedQueue() throws InterruptedException {
        // 添加延迟元素到队列中，第二个参数是过期时间，单位为秒
        RBlockingDeque<String> blockingDeque = redisson.getBlockingDeque("my_delayed_queue");
        // 注意虽然delayedQueue在这个方法里面没有用到，但是这行代码也是必不可少的。
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(blockingDeque);
        delayedQueue.offer("111111111111111", 10, TimeUnit.SECONDS);
        while (true) {
            String orderId = blockingDeque.take();
            log.info("orderId:{}", orderId);
        }
    }

    @Test
    public void addDataToQueue() {
        RDelayedQueue<String> delayedQueue = redisson.getDelayedQueue(redisson.getQueue("my_delayed_queue"));
        for (int i = 0; i < 5; i++) {
            delayedQueue.offer("element" + i, 5 + i, TimeUnit.SECONDS);
        }
        redisson.shutdown();
    }
}
