package com.zhr.out.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHR
 * @version 1.0.0
 * @ClassName RedissionConfig.java
 * @createTime 2020年10月22日 14:13:00
 * @Description TODO
 */

@Configuration
public class RedissionConfig {

    @Bean
    public RedissonClient getRedissonClient() {
        // 1. Create config object
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379")
                .setConnectionMinimumIdleSize(2)
                .setConnectionPoolSize(10);
//        config.useClusterServers()
//                // use "rediss://" for SSL connection
//                .addNodeAddress("redis://127.0.0.1:6379");
        return Redisson.create(config);
        // or read config from file
//        config = Config.fromYAML(new File("config-file.yaml"));
    }

//    public RedissonClient create() {
//        // 1. Create config object
//        Config config = new Config();
//        config.useSingleServer().setAddress("redis://127.0.0.1:6379")
//                .setConnectionMinimumIdleSize(2)
//                .setConnectionPoolSize(10);
////        config.useClusterServers()
////                // use "rediss://" for SSL connection
////                .addNodeAddress("redis://127.0.0.1:6379");
//        return Redisson.create(config);
//        // or read config from file
////        config = Config.fromYAML(new File("config-file.yaml"));
//    }


//    public static void main(String[] args) throws InterruptedException {
//        RedissonClient redissonClient = RedissionConfig.create();
//        RMap<String, String> mymap = redissonClient.getMap("mymap");
//        System.out.println("mymap==================" + mymap);
////        mymap.put("a", "b");
//
//        String a = mymap.get("a");
//        System.out.println("a==================" + a);
//
//
//        RBucket<Object> mystr = redissonClient.getBucket("mystr");
//        mystr.set("myval");
//        mystr.set("myval2");
//
//        System.out.println("mystr==================" + mystr.get());
//
//        for (int i = 0; i < 10; i++) {
//            Thread.sleep(1000);
//            int threads = redissonClient.getConfig().getThreads();
//            System.out.println("threads==================" + threads);
//            int nettyThreads = redissonClient.getConfig().getNettyThreads();
//            System.out.println("nettyThreads==================" + nettyThreads);
//        }
//
//    }
}
