package com.study.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.study.service.SentinelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    private static final Logger logger = LoggerFactory.getLogger(SentinelController.class);

    @Autowired
    private SentinelService sentinelService;

    /**
     * 演示限流功能
     */
    @GetMapping("/test")
    @SentinelResource(value = "/sentinel/test", fallback = "testFallback")
    public String testSentinel(@RequestParam(required = false, defaultValue = "World") String name) {
        logger.info("Testing Sentinel with name: {}", name);
        // 模拟一些处理时间
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Test interrupted: {}", e.getMessage());
        }
        logger.info("Completed Sentinel test for name: {}", name);
        return "Hello " + name + " from Sentinel!";
    }

    /**
     * 限流后的降级方法
     */
    public String testFallback(String name) {
        logger.warn("Sentinel test was limited, returning fallback for name: {}", name);
        return "Sorry " + name + ", the service is busy now!";
    }

    /**
     * 演示熔断降级功能
     */
    @GetMapping("/degrade")
    @SentinelResource(value = "/sentinel/degrade", 
                     fallback = "degradeFallback", 
                     blockHandler = "degradeBlockHandler")
    public String degradeTest(@RequestParam(required = false, defaultValue = "User") String name) {
        logger.info("Testing degradation with name: {}", name);
        // 模拟异常情况
        if ("error".equalsIgnoreCase(name)) {
            logger.error("Simulating exception for degradation test with name: {}", name);
            throw new RuntimeException("Simulated exception for testing degradation");
        }
        
        // 模拟一些处理时间
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Degradation test interrupted: {}", e.getMessage());
        }
        
        logger.info("Completed degradation test for name: {}", name);
        return "Normal response for " + name;
    }

    /**
     * 熔断降级的fallback方法
     */
    public String degradeFallback(String name) {
        logger.warn("Degradation triggered for name: {}", name);
        return "Service degraded for " + name + ", please try again later.";
    }

    /**
     * 被限流时的处理方法
     */
    public String degradeBlockHandler(String name, BlockException ex) {
        logger.error("Request blocked due to flow control for name: {}, reason: {}", name, ex.getMessage());
        return "Request blocked due to flow control for " + name;
    }

    /**
     * 演示热点参数限流
     */
    @GetMapping("/hotparam")
    @SentinelResource(value = "/sentinel/hotparam", fallback = "hotParamFallback")
    public String hotParamTest(@RequestParam String param) {
        logger.info("Testing hot param with param: {}", param);
        return "Hot param test: " + param;
    }

    public String hotParamFallback(String param) {
        logger.warn("Hot param blocked: {}", param);
        return "Hot param blocked: " + param;
    }

    /**
     * 演示异常类型降级
     */
    @GetMapping("/exception")
    @SentinelResource(value = "/sentinel/exception", 
                     fallback = "exceptionFallback",
                     exceptionsToIgnore = {IllegalStateException.class})
    public String exceptionTest(@RequestParam(defaultValue = "normal") String type) {
        logger.info("Testing exception handling with type: {}", type);
        if ("runtime".equals(type)) {
            logger.error("Throwing runtime exception for type: {}", type);
            throw new RuntimeException("Runtime exception occurred");
        } else if ("illegal".equals(type)) {
            logger.info("Throwing illegal state exception for type: {} (this will be ignored)", type);
            throw new IllegalStateException("Illegal state exception occurred");
        }
        logger.info("Completed exception test for type: {}", type);
        return "Success with type: " + type;
    }

    public String exceptionFallback(String type, Throwable ex) {
        logger.error("Exception fallback triggered for type: {}, exception: {}", type, ex.getClass().getSimpleName());
        return "Exception fallback: " + ex.getClass().getSimpleName() + " for type: " + type;
    }

    /**
     * 演示并发线程数限流
     */
    @GetMapping("/concurrent")
    @SentinelResource(value = "/sentinel/concurrent", 
                     fallback = "concurrentFallback")
    public String concurrentTest(@RequestParam(defaultValue = "user") String user) {
        logger.info("Testing concurrent requests for user: {}", user);
        try {
            // 模拟长时间运行的任务
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.warn("Concurrent test interrupted: {}", e.getMessage());
        }
        logger.info("Completed concurrent test for user: {}", user);
        return "Concurrent test completed for " + user;
    }

    public String concurrentFallback(String user) {
        logger.warn("Too many concurrent requests for user: {}", user);
        return "Too many concurrent requests for " + user;
    }

    /**
     * 演示调用服务层的Sentinel注解
     */
    @GetMapping("/service")
    public String testServiceLayer(@RequestParam(defaultValue = "test") String param) {
        logger.info("Testing service layer with param: {}", param);
        String result = sentinelService.doSomething(param);
        logger.info("Service layer test completed with result: {}", result);
        return result;
    }

    /**
     * 演示调用服务层热点参数限流
     */
    @GetMapping("/service-hotparam")
    public String testServiceHotParam(@RequestParam String userId, 
                                      @RequestParam(defaultValue = "default") String commonParam) {
        logger.info("Testing service layer hot param with userId: {}, commonParam: {}", userId, commonParam);
        String result = sentinelService.handleHotParam(userId, commonParam);
        logger.info("Service layer hot param test completed with result: {}", result);
        return result;
    }

    /**
     * 演示调用服务层忽略异常
     */
    @GetMapping("/service-ignore-exception")
    public String testServiceIgnoreException(@RequestParam(defaultValue = "normal") String param) {
        logger.info("Testing service layer ignore exception with param: {}", param);
        String result = sentinelService.ignoreException(param);
        logger.info("Service layer ignore exception test completed with result: {}", result);
        return result;
    }
}