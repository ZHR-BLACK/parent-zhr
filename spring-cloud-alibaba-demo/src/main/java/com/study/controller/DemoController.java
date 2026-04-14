package com.study.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public String sendMessage() {
        logger.info("Sending message to RocketMQ");
        rocketMQTemplate.convertAndSend("test-topic", "Hello RocketMQ!");
        logger.info("Message sent successfully to RocketMQ");
        return "Message sent successfully!";
    }

    @GetMapping("/test-seata")
    @GlobalTransactional
    public String testSeata() {
        logger.info("Testing Seata transaction management");
        // 这里可以添加业务逻辑，Seata 会管理事务
        logger.info("Seata transaction test completed successfully");
        return "Seata transaction test successful!";
    }
}