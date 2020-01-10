package com.zhr.selfstudy.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName TokenDemo
 * @Date 2020-01-08 16:38
 * @description 限流操作
 * 在 Guava 中 RateLimiter 的实现有两种： Bursty 和 WarmUp
 * bursty
 * bursty 基于令牌桶的算法实现。
 * RateLimiter rateLimiter=RateLimiter.create(permitPerSecond); //创建一个 bursty实例。
 * rateLimiter.acquire(); //获取 1 个 permit，当令牌数量不够时会阻塞直到获取为止
 * WarmingUp
 * WarmingUp基于漏桶的算法实现，QPS 是固定的，使用于需要预热时间的使用场景。
 * RateLimiter rateLimiter =RateLimiter.create(permitsPerSecond,warmupPeriod,timeUnit);//warmupPeriod 是指预热的时间
 * rateLimiter.acquire();//获取 1 个 permit
 **/
public class TokenDemo {

    private int qps;
    private int countOfReq;
    private RateLimiter rateLimiter;

    public TokenDemo(int qps, int countOfReq) {
        this.qps = qps;
        this.countOfReq = countOfReq;
    }

    //bursty 基于令牌桶的算法实现
    public TokenDemo processWithTokenBucket() {
        rateLimiter = RateLimiter.create(qps);
        return this;
    }

    //WarmingUp基于漏桶的算法实现，QPS 是固定的，使用于需要预热时间的使用场景
    public TokenDemo processWithLeakyBucket() {
        rateLimiter = RateLimiter.create(qps, 00, TimeUnit.MILLISECONDS);
        return this;
    }

    private void processRequest() {
        System.out.println("RateLimiter:" + rateLimiter.getClass());
        long start = System.currentTimeMillis();
        for (int i = 0; i < countOfReq; i++) {
            rateLimiter.acquire();
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("处理请求数量:" + countOfReq + "," +
                "耗时：" + end + "," +
                "qps:" + rateLimiter.getRate() + "," +
                "实际 qps：" + Math.ceil(countOfReq / (end / 1000.00)));
    }

    public void doProcess() throws InterruptedException {
        for (int i = 0; i < 20; i = i + 5) {
            TimeUnit.SECONDS.sleep(i);
            processRequest();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new TokenDemo(50, 100).processWithTokenBucket().doProcess();
        new TokenDemo(50, 100).processWithLeakyBucket().doProcess();
    }
}
