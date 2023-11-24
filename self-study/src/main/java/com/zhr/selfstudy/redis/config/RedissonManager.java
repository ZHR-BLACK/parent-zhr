package com.zhr.selfstudy.redis.config;

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

    private static Config config = new Config();
    //声明redisso对象
    private static Redisson redisson = null;

    // 实例化redisson,单例模式
    static {
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        //得到redisson对象
        redisson = (Redisson) Redisson.create(config);
    }

    //获取redisson对象的方法
    public static Redisson getRedisson() {
        return redisson;
    }

}
