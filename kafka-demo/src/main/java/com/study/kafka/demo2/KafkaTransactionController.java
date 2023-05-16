package com.study.kafka.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName KafkaTransactionController
 * @Date 2023-05-12 9:08
 * @description kafka 事务中提交
 **/
@RestController
public class KafkaTransactionController {

    @Autowired
    private KafkaTemplate<Object, Object> template;

    @GetMapping("/kafka/inTransaction")
    public void sendInTransaction() {
        // 声明事务：后面报错消息不会发出去
        template.executeInTransaction(operations -> {
            operations.send("my-topic2", "test send in transaction");
            throw new RuntimeException("send fail");
        });
    }

    @GetMapping("/kafka/notInTransaction")
    public void sendNotInTransaction() {
        // 不声明事务：后面报错但前面消息已经发送成功了
        template.send("my-topic2", "test send not In transaction");
        throw new RuntimeException("fail");
    }


}
