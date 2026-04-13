package com.study.controller;

import io.seata.spring.annotation.GlobalTransactional;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public String sendMessage() {
        rocketMQTemplate.convertAndSend("test-topic", "Hello RocketMQ!");
        return "Message sent successfully!";
    }

    @GetMapping("/test-seata")
    @GlobalTransactional
    public String testSeata() {
        // 这里可以添加业务逻辑，Seata 会管理事务
        return "Seata transaction test successful!";
    }
}