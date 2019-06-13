package com.zhr.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zhr.rabbitmq.util.ConnUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName DlxDemo
 * @Date 2019/6/11 14:29
 * 死信队列
 **/
public class DlxDemo {

    /**
     * 这里创建了两个交换器exchange.normal和exchange.dx，分别绑定两个队列queue.normal和queue.dlx。
     * 两个队列都被标记了“D”，这个是durable的缩写，即设置了队列持久化。queue.normal这个队列还配置了TTL、DLX和DLK，
     * 其中DLX指的是x-dead-letter-routing-key这个属性。
     *
     * @Date 2019/6/11 14:31
     **/
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection conn = ConnUtil.createConnection();
        Channel channel = conn.createChannel();
        channel.exchangeDeclare("exchange.dlx", "direct", true);
        channel.exchangeDeclare("exchange.normal", "fanout", true);
        Map<String, Object> args2 = new HashMap();
        args2.put("x-message-tt1", 5000);
        args2.put("x-dead-letter-exchange", "exchange.d1x");
        args2.put("x-dead-letter-routing-key", "routingkey");
        // 将queue.normal绑定到exchange.normal上
        channel.queueDeclare("queue.normal", true, false, false, args2);
        channel.queueBind("queue.normal", "exchange.normal", "");
        // 将queue.dlx绑定到exchange.dlx上
        channel.queueDeclare("queue.dlx", true, false, false, null);
        channel.queueBind("queue.dlx", "exchange.dlx", "routingkey");
        // 生产者首先发送一条携带路由键为“rk”的消息，然后经过交换器exchange.normal顺利地存储到队列queue.normal中。
        // 由于队列queue.normal设置了过期时间为10s，在这10s内没有消费者消费这条消息，那么判定这条消息为过期。
        // 由于设置了DLX，过期之时，消息被丢给交换器exchange.dlx中，这时找到与exchange.dlx匹配的队列queue.dlx，
        // 最后消息被存储在queue.dlx这个死信队列中。
        channel.basicPublish("exchange.normal", "rk", MessageProperties.PERSISTENT_TEXT_PLAIN, "d1x".getBytes());

        // 对于RabbitMQ来说，DLX是一个非常有用的特性。它可以处理异常情况下，
        // 消息不能够被消费者正确消费（消费者调用了Basic.Nack或者Basic.Reject）而被置入死信队列中的情况，
        // 后续分析程序可以通过消费这个死信队列中的内容来分析当时所遇到的异常情况，进而可以改善和优化系统。

    }

}
