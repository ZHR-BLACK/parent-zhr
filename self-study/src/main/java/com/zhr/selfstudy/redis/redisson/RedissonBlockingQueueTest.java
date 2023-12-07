package com.zhr.selfstudy.redis.redisson;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBlockingQueue;

/**
 * @author ZHR
 * @date 2023/11/29
 * @description 阻塞队列
 * 阻塞队列是指当队列为空或者队列已满时，读和写的线程会被阻塞直到队列可用为止。
 * Redisson实现的阻塞队列是基于Redis的brpoplpush命令实现的，通过在列表尾部插入数据，
 * 在列表头部弹出数据的方式来实现阻塞队列的功能。
 */
@Slf4j
public class RedissonBlockingQueueTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    @Test
    public void blockingQueueTest() {
        // 向队列中添加元素，如果队列已满则阻塞等待
        RBlockingQueue<Object> queue = redisson.getBlockingQueue("my_blocking_queue");
        try {
            // 从队列中取出元素，如果队列为空则阻塞等待
            queue.put("element");
            while (true) {
                Object element = queue.take();
                log.info("element:{}", element);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void addDataToBlockingQueue() throws InterruptedException {
        RBlockingQueue<Object> queue = redisson.getBlockingQueue("my_blocking_queue");
        for (int i = 0; i < 5; i++) {
            queue.put("element" + i);
        }
        redisson.shutdown();
    }

}
