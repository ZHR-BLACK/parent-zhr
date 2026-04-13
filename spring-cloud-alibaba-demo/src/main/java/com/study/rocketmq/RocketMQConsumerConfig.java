package com.study.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "test-consumer-group")
public class RocketMQConsumerConfig implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
    }
}