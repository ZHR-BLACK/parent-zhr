package com.zhr.selfstudy.redis;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RQueue;

/**
 * Redisson操作queue队列
 */
@Slf4j
public class RedissonQueueDemo {

    private static final Redisson redisson = RedissonManager.getRedisson();


    public static void main(String[] args) {
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
