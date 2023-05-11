package com.zhr.selfstudy.kafka.demo2;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MultiMethodListener
 * @Date 2023-05-11 9:33
 * @description 多方法监听
 **/
@Component
@KafkaListener(id = "multiGroup", topics = {"multi-my-topic1", "multi-my-topic2"})
public class MultiMethodListener {

    @KafkaHandler
    public void user(User user) {
        System.out.println("multiGroup User Received: " + user.toString());
    }

    @KafkaHandler
    public void role(Role role) {
        System.out.println("multiGroup Role Received: " + role.toString());
    }

    @KafkaHandler(isDefault = true)
    public void unknown(Object object) {
        System.out.println("multiGroup unknown Received: " + object);
    }

}
