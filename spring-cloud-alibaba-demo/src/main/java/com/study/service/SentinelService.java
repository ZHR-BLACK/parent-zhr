package com.study.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SentinelService {

    /**
     * 使用Sentinel注解保护的服务方法
     *
     * @param param 输入参数
     * @return 处理结果
     */
    @SentinelResource(
        value = "sentinelServiceMethod",
        fallback = "doSomethingFallback",
        blockHandler = "doSomethingBlockHandler"
    )
    public String doSomething(String param) {
        try {
            // 模拟一些处理时间
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if ("error".equalsIgnoreCase(param)) {
            throw new RuntimeException("Simulated error for testing");
        }

        return "Processed: " + param;
    }

    /**
     * 降级方法 - 当业务方法抛出异常时调用
     */
    public String doSomethingFallback(String param, Throwable ex) {
        return "Fallback result for param: " + param + ", error: " + ex.getMessage();
    }

    /**
     * 限流处理方法 - 当触发限流规则时调用
     */
    public String doSomethingBlockHandler(String param, BlockException ex) {
        return "Blocked result for param: " + param + ", block reason: " + ex.getRule().getClass().getSimpleName();
    }

    /**
     * 演示热点参数限流的服务方法
     */
    @SentinelResource(
        value = "hotParamServiceMethod",
        fallback = "hotParamFallback"
    )
    public String handleHotParam(String userId, String commonParam) {
        // 模拟业务处理
        return "Handled for user: " + userId + ", param: " + commonParam;
    }

    public String hotParamFallback(String userId, String commonParam, Throwable ex) {
        return "Hot param fallback for user: " + userId;
    }

    /**
     * 演示忽略特定异常的服务方法
     */
    @SentinelResource(
        value = "ignoreExceptionServiceMethod",
        fallback = "ignoreExceptionFallback",
        exceptionsToIgnore = {IllegalArgumentException.class}
    )
    public String ignoreException(String param) {
        if ("runtime".equals(param)) {
            throw new RuntimeException("Runtime exception");
        } else if ("illegal".equals(param)) {
            throw new IllegalArgumentException("Illegal argument exception");
        }
        return "Success with param: " + param;
    }

    public String ignoreExceptionFallback(String param, Throwable ex) {
        return "Fallback for param: " + param + ", exception: " + ex.getClass().getSimpleName();
    }
}