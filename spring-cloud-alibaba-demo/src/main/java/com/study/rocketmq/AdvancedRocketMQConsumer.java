package com.study.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;

/**
 * 高级RocketMQ消费者配置 - 演示手动offset管理和返回处理状态
 */
@Component
public class AdvancedRocketMQConsumer {

    private static final Logger logger = LoggerFactory.getLogger(AdvancedRocketMQConsumer.class);

    @Value("${rocketmq.name-server:localhost:9876}")
    private String nameServer;

    @Value("${rocketmq.consumer.group:test-consumer-group}")
    private String consumerGroup;

    private DefaultMQPushConsumer consumer;

    @PostConstruct
    public void init() throws Exception {
        // 创建消费者实例
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(nameServer);

        // 订阅主题
        consumer.subscribe("test-topic", "*");

        // 设置消息监听器 - 实现手动offset管理
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
                for (MessageExt msg : msgs) {
                    try {
                        // 获取消息内容
                        String messageBody = new String(msg.getBody(), "UTF-8");
                        
                        logger.info("Received message: {}", messageBody);
                        logger.info("Topic: {}", msg.getTopic());
                        logger.info("Tags: {}", msg.getTags());
                        logger.info("Keys: {}", msg.getKeys());
                        logger.info("Message ID: {}", msg.getMsgId());
                        logger.info("Queue ID: {}", msg.getQueueId());
                        logger.info("Queue Offset: {}", msg.getQueueOffset());

                        // 执行业务处理逻辑
                        boolean success = processBusinessLogic(messageBody, msg);

                        if (success) {
                            // 业务处理成功，返回CONSUME_SUCCESS表示提交offset
                            logger.info("Message processed successfully, offset will be committed: {}", msg.getQueueOffset());
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        } else {
                            // 业务处理失败，返回RECONSUME_LATER表示稍后重试
                            logger.warn("Message processing failed, will retry: {}", msg.getQueueOffset());
                            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                        }
                    } catch (Exception e) {
                        logger.error("Error processing message: ", e);
                        
                        // 发生异常时，返回RECONSUME_LATER表示稍后重试
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
                
                // 所有消息处理成功
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        // 启动消费者
        consumer.start();
        logger.info("Advanced RocketMQ Consumer started successfully.");
    }

    /**
     * 处理业务逻辑
     * 
     * @param message 消息内容
     * @param msg 原始消息对象
     * @return 处理是否成功
     */
    private boolean processBusinessLogic(String message, MessageExt msg) {
        try {
            // 这里放置具体的业务处理逻辑
            logger.info("Processing business logic for message: {}", message);
            
            // 模拟业务处理过程
            Thread.sleep(100); // 模拟处理耗时
            
            // 业务处理成功
            logger.info("Business logic processed successfully for message: {}", message);
            
            // 返回true表示处理成功，可以提交offset
            return true;
        } catch (InterruptedException e) {
            logger.error("Business logic processing interrupted: ", e);
            Thread.currentThread().interrupt();
            // 返回false表示处理失败，不应提交offset
            return false;
        } catch (Exception e) {
            logger.error("Business logic processing failed: ", e);
            // 返回false表示处理失败，不应提交offset
            return false;
        }
    }

    @PreDestroy
    public void destroy() {
        if (consumer != null) {
            consumer.shutdown();
            logger.info("Advanced RocketMQ Consumer shutdown.");
        }
    }
}