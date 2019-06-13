package com.zhr.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.MessageProperties;
import com.zhr.rabbitmq.util.ConnUtil;

import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.TimeoutException;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName AsynchronousConfirmDemo
 * @Date 2019/6/11 16:04
 * 异步confirm，RabbitMQ实战书中的例子
 **/
public class AsynchronousConfirmDemo {

    public static void main(String[] args) throws IOException, TimeoutException {

        Connection conn = ConnUtil.createConnection();
        Channel channel = conn.createChannel();

        channel.confirmSelect();

        SortedSet<Long> confirmSet = new TreeSet();
        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) {
                System.out.println("Nack,Seqno: " + l + ",multiple:" + b);
                if (b) {
                    confirmSet.headSet(l - 1).clear();
                } else {
                    confirmSet.remove(l);
                }
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                if (b) {
                    confirmSet.headSet(l - 1).clear();
                } else {
                    confirmSet.remove(l);
                }
                // 这里需要添加处理消息重发的场景
            }
        });

        // 演示一直发送消息的场景
        while (true) {
            long nextSeqNo = channel.getNextPublishSeqNo();
            channel.basicPublish("exchangeName", "routingKey1", MessageProperties.PERSISTENT_TEXT_PLAIN, "asdasdasdasd".getBytes());
            confirmSet.add(nextSeqNo);
        }

    }
}
