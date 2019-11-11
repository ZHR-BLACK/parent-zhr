package com.zhr.selfstudy.retry;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName RetryDemo
 * @Date 2019-10-29 18:18
 * @description 重试demo
 * <dependency>
 * <groupId>com.github.rholder</groupId>
 * <artifactId>guava-retrying</artifactId>
 * <version>2.0.0</version>
 * </dependency>
 **/
public class RetryDemo {

    public static void main(String[] args) throws Exception {
        RetryDemo demo = new RetryDemo();
        demo.test();
    }

    public Boolean test() throws Exception {
        //定义重试机制
        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                //retryIf 重试条件
                .retryIfException()
                .retryIfRuntimeException()
                .retryIfExceptionOfType(Exception.class)
                .retryIfException(Predicates.equalTo(new Exception()))
                .retryIfResult(Predicates.equalTo(false))
                //等待策略：每次请求间隔1s
                .withWaitStrategy(WaitStrategies.fixedWait(1, TimeUnit.SECONDS))
                //停止策略 : 尝试请求6次
                .withStopStrategy(StopStrategies.stopAfterAttempt(6))
                //时间限制 : 某次请求不得超过2s , 类似: TimeLimiter timeLimiter = new SimpleTimeLimiter();
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(2, TimeUnit.SECONDS))
                .build();

        //定义请求实现
        Callable<Boolean> callable = new Callable<Boolean>() {
            int times = 1;

            @Override
            public Boolean call() throws Exception {
                System.out.println("call times=" + times);
                times++;
                if (times == 2) {
                    throw new NullPointerException();
                } else if (times == 3) {
                    throw new Exception();
                } else if (times == 4) {
                    throw new RuntimeException();
                } else if (times == 5) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        //利用重试器调用请求
        return retryer.call(callable);
    }
}
