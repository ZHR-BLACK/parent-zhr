package com.zhr.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zhr.rabbitmq.util.ConnUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 当mandatory参数设为true时
 * @author ZHR
 * @version 1.0
 * @ClassName Demo01
 * @Date 2019/6/11 11:41
 **/
public class Demo01 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection conn = ConnUtil.createConnection();
        Channel channel = conn.createChannel();

        channel.exchangeDeclare("exchangeName", "direct", true);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "exchangeName", "routingKey1");

        // 当mandatory参数设为true时，交换器无法根据自身的类型和路由键找到一个符合条件的队列，那么RabbitMQ会调用Basic.Return命令将消息返回给生产者。
        // 当mandatory参数设置为false时，出现上述情形，则消息直接被丢弃。
        // 那么生产者如何获取到没有被正确路由到合适队列的消息呢？这时候可以通过调用channe1.addReturnListener 来添加ReturnListener监听器实现。
        channel.basicPublish("exchangeName", "", true, MessageProperties.PERSISTENT_TEXT_PLAIN, "mandatory test".getBytes());
        channel.addReturnListener((replyCode, replyText, exchange, routingKey, basicProperties, body) -> {
            String message = new String(body);
            System.out.println("Basic.Return返回的结果是：" + message);
        });
        // 上面代码中生产者没有成功地将消息路由到队列，此时RabbitMQ会通过Basic.Return返回“mandatory test”这条消息，
        // 之后生产者客户端通过ReturnListener监听到了这个事件，上面代码的最后输出应该是“Basic.Return返回的结果是：mandatory test”。


    }

}
