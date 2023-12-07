package com.zhr.selfstudy.redis.redisson;

import com.zhr.selfstudy.redis.config.RedissonManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RTopic;
import org.redisson.api.listener.MessageListener;
import org.redisson.api.listener.StatusListener;
import org.redisson.client.codec.StringCodec;

import java.util.List;

/**
 * @author ZHR
 * @date 2023/11/29
 * @description Redisson的可靠订阅
 * Redisson提供了可靠订阅的功能，支持订阅主题、模式匹配、按照参数订阅等模式。
 * Redisson的可靠订阅是基于Redis的pub/sub命令实现的，通过向Redis发送subscribe/psubscribe命令来实现订阅功能，
 * 通过向Redis发送unsubscribe/punsubscribe命令来取消订阅。在使用可靠订阅时，Redisson会启动一个线程用于接收订阅的消息，
 * 并通过回调函数将消息推送给应用程序。
 * <p>
 * 发布消息与监听消息要运行在不同的 JVM，如果使用同一个 redissonClient 发布的话，不会监听到自己的消息。
 */
@Slf4j
public class RedissonSubscribeTest {

    private static final Redisson redisson = RedissonManager.getRedisson();

    @Test
    public void publishTest() {
        RTopic topic = redisson.getTopic("my_topic");
        // 发布消息
        topic.publish("hello world");
        redisson.shutdown();
    }


    @Test
    public void subscribeTest() {
        RTopic topic = redisson.getTopic("my_topic");
        // 订阅消息
        int listenerId = topic.addListener(String.class, (channel, msg) -> {
            log.info("onMessage-channel:{}-msg:{}", channel, msg);
        });
        // 取消订阅
        topic.removeListener(listenerId);
    }


}
