# Spring Cloud Alibaba 示例模块

## 项目简介

本模块演示了如何集成 Spring Cloud Alibaba 生态，包括 Nacos、RocketMQ、Seata 和 Sentinel 等组件。

## 技术栈

- Spring Boot 2.7.14
- Spring Cloud 2021.0.5
- Spring Cloud Alibaba 2021.0.5.0
- Nacos
- RocketMQ
- Seata
- Sentinel
- MyBatis-Plus
- MySQL

## 快速开始

### 前提条件

1. 安装并启动 Nacos 服务（默认端口 8848）
2. 安装并启动 RocketMQ 服务
3. 安装并启动 Seata 服务
4. 安装 Maven

### 构建项目

在根目录执行以下命令：

```bash
mvn clean install
```

### 运行应用

运行 `SpringCloudAlibabaDemoApplication` 类启动应用。

### 测试功能

1. **测试 RocketMQ 消息发送**：
   - 访问 `http://localhost:8080/send`
   - 查看控制台输出，应该能看到消息发送成功的日志

2. **测试 Seata 事务管理**：
   - 访问 `http://localhost:8080/test-seata`
   - 查看控制台输出，应该能看到事务测试成功的日志

3. **测试 Sentinel 熔断降级**：
   - 访问 `http://localhost:8080/sentinel/test?name=TestUser` 测试基本功能
   - 快速连续访问 `http://localhost:8080/sentinel/test` 测试限流功能（每秒最多2个请求）
   - 访问 `http://localhost:8080/sentinel/degrade?name=error` 测试降级功能
   - 访问 `http://localhost:8080/sentinel/hotparam?param=test` 测试热点参数限流
   - 访问 `http://localhost:8080/sentinel/exception?type=runtime` 测试异常降级功能
   - 访问 `http://localhost:8080/sentinel/exception?type=illegal` 测试忽略特定异常（不会触发降级）
   - 访问 `http://localhost:8080/sentinel/concurrent?user=test` 测试并发线程数限流
   - 访问 `http://localhost:8080/sentinel/service?param=normal` 测试服务层注解保护
   - 访问 `http://localhost:8080/sentinel/service?param=error` 测试服务层异常降级
   - 访问 `http://localhost:8080/sentinel/service-hotparam?userId=user1&commonParam=param1` 测试服务层热点参数限流
   - 访问 `http://localhost:8080/sentinel/service-ignore-exception?param=runtime` 测试服务层异常降级
   - 访问 `http://localhost:8080/sentinel/service-ignore-exception?param=illegal` 测试服务层忽略特定异常

## 项目结构

```
spring-cloud-alibaba-demo/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── study/
        │           ├── SpringCloudAlibabaDemoApplication.java  # 主应用类
        │           ├── controller/
        │           │   ├── DemoController.java                # 示例控制器
        │           │   └── SentinelController.java            # Sentinel 控制器
        │           ├── rocketmq/
        │           │   ├── RocketMQProducerConfig.java        # RocketMQ 生产者配置
        │           │   └── RocketMQConsumerConfig.java        # RocketMQ 消费者配置
        │           ├── seata/
        │           │   └── SeataConfig.java                   # Seata 配置
        │           ├── sentinel/
        │           │   └── SentinelConfig.java                # Sentinel 配置
        │           └── service/
        │               └── SentinelService.java               # Sentinel 服务层
        └── resources/
            └── bootstrap.yml                                  # 配置文件
```

## 配置说明

### bootstrap.yml

```yaml
spring:
  application:
    name: spring-cloud-alibaba-demo
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
      config:
        server-addr: localhost:8848
        file-extension: yml
```

### 依赖说明

- **Spring Cloud Alibaba Nacos Discovery**：服务注册与发现
- **Spring Cloud Alibaba Nacos Config**：配置中心
- **Spring Cloud Alibaba Sentinel**：熔断降级
- **Spring Cloud Stream RocketMQ**：消息队列
- **Spring Cloud Alibaba Seata**：分布式事务
- **MyBatis-Plus**：ORM 框架
- **MySQL**：数据库驱动

## 注意事项

1. 确保所有中间件服务（Nacos、RocketMQ、Seata）都已启动
2. Sentinel Dashboard 可选，用于可视化监控和规则配置
3. 限流规则在 SentinelConfig 中预设，也可通过 Dashboard 动态调整