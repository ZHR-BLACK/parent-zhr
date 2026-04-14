package com.study.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class SentinelService {

    private static final Logger logger = LoggerFactory.getLogger(SentinelService.class);

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
        logger.info("Processing in service method with param: {}", param);
        try {
            // 模拟一些处理时间
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Service method interrupted: {}", e.getMessage());
        }

        if ("error".equalsIgnoreCase(param)) {
            logger.error("Simulating error for testing with param: {}", param);
            throw new RuntimeException("Simulated error for testing");
        }

        logger.info("Successfully processed param: {}", param);
        return "Processed: " + param;
    }

    /**
     * 降级方法 - 当业务方法抛出异常时调用
     */
    public String doSomethingFallback(String param, Throwable ex) {
        logger.warn("Fallback triggered for param: {}, error: {}", param, ex.getMessage());
        return "Fallback result for param: " + param + ", error: " + ex.getMessage();
    }

    /**
     * 限流处理方法 - 当触发限流规则时调用
     */
    public String doSomethingBlockHandler(String param, BlockException ex) {
        logger.error("Block handler triggered for param: {}, block reason: {}", param, ex.getRule().getClass().getSimpleName());
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
        logger.info("Handling hot param for user: {}, param: {}", userId, commonParam);
        // 模拟业务处理
        String result = "Handled for user: " + userId + ", param: " + commonParam;
        logger.info("Hot param handling completed with result: {}", result);
        return result;
    }

    public String hotParamFallback(String userId, String commonParam, Throwable ex) {
        logger.warn("Hot param fallback triggered for user: {}, param: {}", userId, commonParam);
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
        logger.info("Processing ignore exception method with param: {}", param);
        if ("runtime".equals(param)) {
            logger.error("Throwing runtime exception for param: {}", param);
            throw new RuntimeException("Runtime exception");
        } else if ("illegal".equals(param)) {
            logger.info("Throwing illegal argument exception for param: {} (will be ignored)", param);
            throw new IllegalArgumentException("Illegal argument exception");
        }
        logger.info("Successfully completed ignore exception method with param: {}", param);
        return "Success with param: " + param;
    }

    public String ignoreExceptionFallback(String param, Throwable ex) {
        logger.warn("Ignore exception fallback triggered for param: {}, exception: {}", param, ex.getClass().getSimpleName());
        return "Fallback for param: " + param + ", exception: " + ex.getClass().getSimpleName();
    }
}