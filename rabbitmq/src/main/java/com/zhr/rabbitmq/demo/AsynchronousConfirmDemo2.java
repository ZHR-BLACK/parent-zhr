package com.zhr.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zhr.rabbitmq.util.ConnUtil;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AsynchronousConfirmDemo2
 * @Date 2019/6/11 17:03
 * 异步confirm
 **/
public class AsynchronousConfirmDemo2 {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection conn = ConnUtil.createConnection();
        Channel channel = conn.createChannel();

        channel.exchangeDeclare("exchangeName", "direct", true);
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, "exchangeName", "routingKey1");
        channel.queueDeclare("queueName", false, false, false, null);

        // 开启发送方确认模式
        channel.confirmSelect();
        for (int i = 0; i < 10; i++) {
            String message = String.format("时间 => %s", new Date().getTime());
            channel.basicPublish("exchangeName", "", MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes("UTF-8"));
        }
        // 异步监听确认和未确认的消息
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleNack(long deliveryTag, boolean multiple) throws IOException {
                System.out.println("未确认消息，标识：" + deliveryTag);
            }
            @Override
            public void handleAck(long deliveryTag, boolean multiple) throws IOException {
                System.out.println(String.format("已确认消息，标识：%d，多个消息：%b", deliveryTag, multiple));
            }
        });

    }

}
