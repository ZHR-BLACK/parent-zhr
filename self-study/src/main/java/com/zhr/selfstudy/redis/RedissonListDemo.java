package com.zhr.selfstudy.redis;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RList;

import java.util.List;

@Slf4j
public class RedissonListDemo {

    private static final Redisson redisson = RedissonManager.getRedisson();


    public static void main(String[] args) {
        //====================操作list====================
        RList<String> list = redisson.getList("list");
        list.add("victory1");
        list.add("victory2");
        log.info("list:{}", list);

        //取值
        List<Object> list1 = redisson.getList("list").readAll();
        log.info("list1:{}", list1);
        //移除索引0位置元素
        list.remove(0);
        log.info("list:{}", list);
        //通过key取value值
        List<Object> list2 = redisson.getList("list").get();
        log.info("list2:{}", list2);

        //====================关闭客户端====================
        redisson.shutdown();
    }
}
