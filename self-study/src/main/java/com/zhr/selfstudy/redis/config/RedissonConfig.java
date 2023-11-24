package com.zhr.selfstudy.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RedissonConfig
 * @Date 2023-07-28 15:28
 * @description RedissonConfig
 * Redisson支持自动重试策略，默认是重试3次，间隔为1000ms。
 **/
@Configurable
public class RedissonConfig {

    /**
     * 集群模式
     */
    @Bean
    public RedissonClient client() {
        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // cluster state scan interval in milliseconds
                .addNodeAddress("redis://127.0.0.1:7000", "redis://127.0.0.1:7001");
        return Redisson.create(config);
    }

    /**
     * 单例模式
     */
    @Bean
    public RedissonClient client2() {
        RedissonClient redisson = Redisson.create();
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
    }

    /**
     * 哨兵模式
     */
    @Bean
    public RedissonClient client3() {
        Config config = new Config();
        config.useMasterSlaveServers()
                .setMasterAddress("redis://127.0.0.1:6379")
                .addSlaveAddress("redis://127.0.0.1:6389", "redis://127.0.0.1:6332", "redis://127.0.0.1:6419");
        return Redisson.create(config);
    }

    /**
     * 主从模式
     */
    @Bean
    public RedissonClient client4() {
        Config config = new Config();
        config.useMasterSlaveServers()
                .setMasterAddress("redis://127.0.0.1:6379")
                .addSlaveAddress("redis://127.0.0.1:6389", "redis://127.0.0.1:6332", "redis://127.0.0.1:6419");
        return Redisson.create(config);
    }


}
