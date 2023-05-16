package com.study.kafka.demo2;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SimpleProducerConfig
 * @Date 2023-05-10 15:09
 * @description SimpleProducerConfig
 **/
@Configuration
public class SimpleProducerConfig {

    /**
     * 通过配置的方式初始化一个 Topic(my-topic1)， 如果不初始化Topic, 在发送到一个不存在的topic时，会自动创建，
     * 只是副本、分区数量都是1。
     * partitions : 分区数量： 10
     * replicas： 副本数量 1 个
     *
     * @return
     */
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name("my-topic1")
                .partitions(10)
                .replicas(1)
                .build();
    }

}
