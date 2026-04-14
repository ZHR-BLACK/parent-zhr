package com.study.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.study.service.SentinelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/sentinel")
public class SentinelController {

    @Autowired
    private SentinelService sentinelService;

    /**
     * 演示限流功能
     */
    @GetMapping("/test")
    @SentinelResource(value = "/sentinel/test", fallback = "testFallback")
    public String testSentinel(@RequestParam(required = false, defaultValue = "World") String name) {
        // 模拟一些处理时间
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Hello " + name + " from Sentinel!";
    }

    /**
     * 限流后的降级方法
     */
    public String testFallback(String name) {
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
        // 模拟异常情况
        if ("error".equalsIgnoreCase(name)) {
            throw new RuntimeException("Simulated exception for testing degradation");
        }
        
        // 模拟一些处理时间
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        return "Normal response for " + name;
    }

    /**
     * 熔断降级的fallback方法
     */
    public String degradeFallback(String name) {
        return "Service degraded for " + name + ", please try again later.";
    }

    /**
     * 被限流时的处理方法
     */
    public String degradeBlockHandler(String name, BlockException ex) {
        return "Request blocked due to flow control for " + name;
    }

    /**
     * 演示热点参数限流
     */
    @GetMapping("/hotparam")
    @SentinelResource(value = "/sentinel/hotparam", fallback = "hotParamFallback")
    public String hotParamTest(@RequestParam String param) {
        return "Hot param test: " + param;
    }

    public String hotParamFallback(String param) {
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
        if ("runtime".equals(type)) {
            throw new RuntimeException("Runtime exception occurred");
        } else if ("illegal".equals(type)) {
            throw new IllegalStateException("Illegal state exception occurred");
        }
        return "Success with type: " + type;
    }

    public String exceptionFallback(String type, Throwable ex) {
        return "Exception fallback: " + ex.getClass().getSimpleName() + " for type: " + type;
    }

    /**
     * 演示并发线程数限流
     */
    @GetMapping("/concurrent")
    @SentinelResource(value = "/sentinel/concurrent", 
                     fallback = "concurrentFallback")
    public String concurrentTest(@RequestParam(defaultValue = "user") String user) {
        try {
            // 模拟长时间运行的任务
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return "Concurrent test completed for " + user;
    }

    public String concurrentFallback(String user) {
        return "Too many concurrent requests for " + user;
    }

    /**
     * 演示调用服务层的Sentinel注解
     */
    @GetMapping("/service")
    public String testServiceLayer(@RequestParam(defaultValue = "test") String param) {
        return sentinelService.doSomething(param);
    }

    /**
     * 演示调用服务层热点参数限流
     */
    @GetMapping("/service-hotparam")
    public String testServiceHotParam(@RequestParam String userId, 
                                      @RequestParam(defaultValue = "default") String commonParam) {
        return sentinelService.handleHotParam(userId, commonParam);
    }

    /**
     * 演示调用服务层忽略异常
     */
    @GetMapping("/service-ignore-exception")
    public String testServiceIgnoreException(@RequestParam(defaultValue = "normal") String param) {
        return sentinelService.ignoreException(param);
    }
}