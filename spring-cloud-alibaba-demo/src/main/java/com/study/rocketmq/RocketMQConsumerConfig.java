package com.study.rocketmq;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
    topic = "test-topic", 
    consumerGroup = "test-consumer-group",
    consumeMode = ConsumeMode.CONCURRENTLY // 并发消费模式
)
public class RocketMQConsumerConfig implements RocketMQListener<MessageExt> {
    
    private static final Logger logger = LoggerFactory.getLogger(RocketMQConsumerConfig.class);
    
    @Override
    public void onMessage(MessageExt messageExt) {
        try {
            // 获取消息体
            String message = new String(messageExt.getBody());
            logger.info("Received message: {}", message);
            
            // 手动处理业务逻辑
            processBusinessLogic(message);
            
            // 如果业务处理成功，RocketMQ会自动提交offset
            logger.info("Message processed successfully, offset will be auto-committed: {}", messageExt.getQueueOffset());
            
        } catch (Exception e) {
            logger.error("Failed to process message: ", e);
            // 在并发消费模式下，抛出异常会让RocketMQ进行重试
            throw new RuntimeException(e);
        }
    }
    
    /**
     * 模拟业务处理逻辑
     */
    private void processBusinessLogic(String message) {
        // 这里放置具体的业务处理逻辑
        try {
            // 模拟业务处理耗时
            Thread.sleep(100);
            
            // 业务处理成功，返回
            logger.info("Business logic processed successfully for message: {}", message);
        } catch (InterruptedException e) {
            logger.error("Business processing interrupted: ", e);
            // 重要：如果线程被中断，应恢复中断状态
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        } catch (Exception e) {
            logger.error("Business processing failed: ", e);
            throw new RuntimeException(e);
        }
    }
}