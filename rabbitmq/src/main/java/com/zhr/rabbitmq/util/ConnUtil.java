package com.zhr.rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ConnUtil
 * @Date 2019/6/11 11:56
 * 创建rabbimq连接
 **/
public class ConnUtil {

    public static Connection createConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername("root");
        factory.setPassword("root");
        factory.setVirtualHost("/");
        factory.setHost("111.231.107.12");
        factory.setPort(5672);
        return factory.newConnection();
    }
}
