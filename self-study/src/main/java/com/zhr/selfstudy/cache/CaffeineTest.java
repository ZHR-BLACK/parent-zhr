package com.zhr.selfstudy.cache;

import com.alibaba.fastjson.JSON;
import com.github.benmanes.caffeine.cache.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName CaffeineDemo
 * @Date 2023-08-01 11:20
 * @description Caffeine应用
 **/

public class CaffeineTest {

    /**
     * @author: ZHR
     * @updateTime: 2023-08-01 16:54
     * @description: 手动加载
     */
    @Test
    public void testCache() {
        Cache<String, User> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10000)
                .build();

        // 查找一个缓存元素， 没有查找到的时候返回null
        User user = cache.getIfPresent("aa");
        System.out.println(JSON.toJSONString(user));
        // 查找缓存，如果缓存不存在则生成缓存元素,  如果无法生成则返回null
        user = cache.get("aa", k -> new User());
        System.out.println(JSON.toJSONString(user));
        // 添加或者更新一个缓存元素
        cache.put("aa", User.builder().id(2L).name("张三").build());
        System.out.println(cache.getIfPresent("aa"));
        // 移除一个缓存元素
        cache.invalidate("aa");
        System.out.println(cache.getIfPresent("aa"));
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-08-01 16:52
     * @description: 自动加载
     */
    @Test
    public void testLoadingCache() {
        LoadingCache<String, User> cache = Caffeine.newBuilder()
                .maximumSize(10000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .build(key -> User.builder().id(2L).name("张三").build());

        cache.put("bb", User.builder().id(3L).name("李四").age(23).build());
        System.out.println(JSON.toJSONString(cache.get("bb")));

        User user = cache.get("a");
        System.out.println(JSON.toJSONString(user));
        // 批量查找缓存，如果缓存不存在则生成缓存元素
        Map<String, User> userMap = cache.getAll(Arrays.asList("aa", "bb"));
        System.out.println(userMap);
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-08-01 14:09
     * @description: 手动异步加载
     */
    @Test
    public void testAsyncCache() throws ExecutionException, InterruptedException {
        AsyncCache<String, User> cache = Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .maximumSize(10000)
                .buildAsync();

        // 查找一个缓存元素， 没有查找到的时候返回null
        CompletableFuture<User> graph = cache.getIfPresent("aa");
        System.out.println(JSON.toJSONString(graph));
        // 查找缓存元素，如果不存在，则异步生成
        graph = cache.get("aa", k -> User.builder().build());
        System.out.println(JSON.toJSONString(graph.get()));
        // 添加或者更新一个缓存元素
        cache.put("aa", graph);
        System.out.println(JSON.toJSONString(cache.getIfPresent("aa")));
        // 移除一个缓存元素
        cache.synchronous().invalidate("aa");
    }

    /**
     * @author: ZHR
     * @updateTime: 2023-08-01 14:19
     * @description: 自动异步加载
     */
    @Test
    public void testAsyncLoadingCache() throws ExecutionException, InterruptedException {
        AsyncLoadingCache<String, User> asyncLoadingCache = Caffeine.newBuilder()
                .initialCapacity(1000) // 指定初始容量
                .maximumSize(10000L) // 指定最大容量
                .expireAfterWrite(3L, TimeUnit.SECONDS) // 指定写入3s后过期
                .refreshAfterWrite(1L, TimeUnit.SECONDS) // 指定每隔1s刷新下数据内容
                .removalListener((key, value, cause) ->
                        System.out.println(key + "移除，原因：" + cause)) // 监听记录移除事件
                .recordStats() // 开启缓存操作数据统计
                .buildAsync(key -> User.builder().id(2L).name("张三").build()); // 构建异步CacheLoader加载类型的缓存对象

        System.out.println(JSON.toJSONString(asyncLoadingCache.get("aa").get()));
        Thread.sleep(5000);
        System.out.println("=============================");
        System.out.println(JSON.toJSONString(asyncLoadingCache.get("aa").get()));
    }

}
