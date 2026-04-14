package com.study.sentinel;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SentinelConfig {

    private static final Logger logger = LoggerFactory.getLogger(SentinelConfig.class);

    /**
     * 初始化流量控制规则
     */
    @PostConstruct
    public void initFlowRules() {
        logger.info("Initializing Sentinel flow rules...");
        
        List<FlowRule> rules = new ArrayList<>();
        
        // 为 /sentinel/test 接口设置限流规则
        FlowRule rule1 = new FlowRule();
        rule1.setResource("/sentinel/test");
        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS); // 按QPS限流
        rule1.setCount(2); // 每秒最多2个请求
        rules.add(rule1);
        logger.info("Added flow rule for /sentinel/test (2 QPS)");
        
        // 为 /sentinel/degrade 接口设置降级规则
        FlowRule rule2 = new FlowRule();
        rule2.setResource("/sentinel/degrade");
        rule2.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule2.setCount(1); // 每秒最多1个请求
        rules.add(rule2);
        logger.info("Added flow rule for /sentinel/degrade (1 QPS)");

        FlowRuleManager.loadRules(rules);
        logger.info("Sentinel flow rules loaded successfully.");
    }
}