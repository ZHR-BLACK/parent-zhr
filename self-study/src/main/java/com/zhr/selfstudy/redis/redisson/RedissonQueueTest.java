package com.zhr.selfstudy.redis.redisson;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RQueue;

/**
 * Redisson操作queue队列
 * 无界队列
 * 无界队列是指队列的大小没有限制，可以一直存储数据。Redisson实现的无界队列是基于Redis的list命令实现的，
 * 通过在列表尾部插入数据，在列表头部弹出数据的方式来实现无界队列的功能。
 */
@Slf4j
public class RedissonQueueTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    @Test
    public void queueTest() {
        //====================操作queue====================
        RQueue<Object> queue = redisson.getQueue("queue");
        // 存值
        queue.add("victory1");
        queue.add("victory2");
        // 取头元素值
        String item = (String) queue.poll();
        log.info(item);
        // 查询队列中所有值
        RQueue<Object> queue1 = redisson.getQueue("queue");
        log.info("queue1:{}", queue1);

        //====================关闭客户端====================
        redisson.shutdown();
    }

}
