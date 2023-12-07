package com.zhr.selfstudy.redis.redisson;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RedissonDemo
 * @Date 2023-07-28 15:25
 * @description RedissonDemo
 **/
@Slf4j
public class RedissonLockTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    @Test
    public void lockTest() {
        RLock rLock = redisson.getLock("myLock");
        boolean locked = false;
        try {
            // 尝试5秒内获取锁，如果获取到了，最长60秒自动释放
            locked = rLock.tryLock(5, 60, TimeUnit.SECONDS);
            if (locked) {
                log.info("加锁成功");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (locked) {
                rLock.unlock();
                log.info("释放锁成功");
            }
        }
    }

}
