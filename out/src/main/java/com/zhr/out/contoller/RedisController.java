package com.zhr.out.contoller;

import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RedisController
 * @Date 2020-10-22 15:21
 * @description todo
 **/
@RestController
public class RedisController {

    private static Logger log = LoggerFactory.getLogger(RedisController.class);

    @Resource
    private RedissonClient redissonClient;

    @RequestMapping(value = "/redisTest", method = RequestMethod.POST)
    public void redisTest() {
        RBucket<Object> aaa = redissonClient.getBucket("aaa");
        aaa.set("bbbb");

        System.out.println("aaa==================" + aaa.get());
    }

}
