package com.zhr.selfstudy.redis.redisson;

import com.zhr.selfstudy.redis.config.RedissonManager;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;

/**
 * @author ZHR
 * @date 2023/11/29
 * @description 基于 Redis 的计数器
 * 分布式限流器
 */
public class RedissonCountTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    @Test
    public void atomicLong() throws Exception {
        RAtomicLong counter = redisson.getAtomicLong("my_counter");
        // 每次请求时增加计数器的值
        for (int i = 0; i < 11; i++) {
            counter.incrementAndGet();
        }
        // 如果计数器的值超过阈值，则限制请求
        if (counter.get() > 20) {
            throw new Exception("Too many requests" + counter.get());
        }
        redisson.shutdown();
    }

}
