package com.zhr.selfstudy.kafka.demo2;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SimpleConsumer
 * @Date 2023-05-10 15:14
 * @description SimpleConsumer
 **/
@Component
public class SimpleConsumer {

    @KafkaListener(id = "myId", topics = "my-topic1")
    public void listen(User user) {
        System.out.println(user.toString());
    }

}
