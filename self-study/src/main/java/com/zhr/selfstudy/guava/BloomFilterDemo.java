package com.zhr.selfstudy.guava;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName BloomFilter
 * @Date 2023-07-28 14:44
 * @description 布隆过滤器
 **/
@Slf4j
public class BloomFilterDemo {

    @Test
    public void filterTest(){
        int total = 1000000;
        // 错误率默认是0.03,可以指定错误率，越小错误率越少，占用空间越大
        BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), total,0.003);
        for (int i = 0; i < total; i++) {
            bf.put("" + i);
        }
        int count = 0;
        for (int i = 0; i < total + 10000; i++) {
            if(bf.mightContain("" + i)){
                count++;
            }
        }
        System.out.println("匹配数量:" + count);
    }

}
