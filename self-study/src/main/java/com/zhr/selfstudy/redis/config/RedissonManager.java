package com.zhr.selfstudy.redis.config;

import lombok.Getter;
import org.redisson.Redisson;
import org.redisson.config.Config;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RedissonManager
 * @Date 2023-07-28 16:11
 * @description RedissonManager
 **/
public class RedissonManager {

    private static final Config config = new Config();
    //获取redisson对象的方法
    //声明redisso对象
    @Getter
    private static Redisson redisson;

    // 实例化redisson,单例模式
    static {
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0);
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);
    }

}
