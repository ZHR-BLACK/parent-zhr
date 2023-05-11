package com.zhr.selfstudy.kafka.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ProducerController
 * @Date 2023-05-10 15:13
 * @description ProducerController
 **/
@RestController
public class ProducerController {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @RequestMapping("send")
    public String sendMessage(@RequestBody User user) {
        kafkaTemplate.send("my-topic1", user);
        return "success";
    }

}
