package com.zhr.selfstudy.redis.bloom;

import com.zhr.selfstudy.redis.config.RedissonManager;
import io.rebloom.client.Client;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;

/**
 * @author ZHR
 * @date 2023/11/29
 * @description 布隆过滤器
 */
@Slf4j
public class BloomFilterTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    private static RBloomFilter<Object> filter;

    /**
     * @author ZHR
     * @date 2023/11/29	16:04
     * @description 初始化布隆过滤器
     */
    static {
        filter = redisson.getBloomFilter("bloom_filter");
        filter.tryInit(100000000L, 0.01);
    }

    @Test
    public void filterTest() {
        filter.add("1");
        filter.add("2");

        boolean contains = filter.contains("1");
        log.info("contains:{}", contains);

        boolean contains2 = filter.contains("5");
        log.info("contains2:{}", contains2);
    }

}
