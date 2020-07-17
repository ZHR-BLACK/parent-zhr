package com.zhr.selfstudy.log;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Slf4jLogbackDemo
 * @Date 2020-07-06 11:41
 * @description 测试logback日志
 **/
public class Slf4jLogbackDemo {

    Logger logger = LoggerFactory.getLogger(Slf4jLogbackDemo.class);

    @Test
    public void test() {
        logger.trace("trace log..");
        logger.debug("debug log..");
        logger.info("info log..");
        logger.warn("warning log");
        logger.error("error log..");
    }

    @Test
    public void test2() {
        for (int i = 0; i < 10; i++) {
            logger.info("第{}次",i + 1);
        }
    }



}