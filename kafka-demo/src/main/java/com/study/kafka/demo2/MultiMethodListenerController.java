package com.study.kafka.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MultiMethodListenerController
 * @Date 2023-05-11 9:33
 * @description 多方法监听 ProducerController
 **/
@RestController
public class MultiMethodListenerController {

    @Autowired
    private KafkaTemplate<String, Object> template;

    @PostMapping(path = "/send/user")
    public void sendFoo() {
        User build = User.builder().age(20).sex(1).build();
        this.template.send("multi-my-topic1", build);
    }

    @PostMapping(path = "/send/role")
    public void sendBar(@RequestBody Role role) {
        this.template.send("multi-my-topic2", role);
    }

    @PostMapping(path = "/send/unknown/{what}")
    public void sendUnknown(@PathVariable String what) {
        this.template.send("multi-my-topic2", what);
    }

}
