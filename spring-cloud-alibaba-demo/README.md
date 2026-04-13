# Spring Cloud Alibaba 示例模块

## 项目简介

本模块演示了如何集成 Spring Cloud Alibaba 生态，包括 Nacos、RocketMQ 和 Seata 等组件。

## 技术栈

- Spring Boot 2.7.14
- Spring Cloud 2021.0.5
- Spring Cloud Alibaba 2021.0.5.0
- RocketMQ
- Seata
- Nacos
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
        │           │   └── DemoController.java                # 示例控制器
        │           ├── rocketmq/
        │           │   ├── RocketMQProducerConfig.java        # RocketMQ 生产者配置
        │           │   └── RocketMQConsumerConfig.java        # RocketMQ 消费者配置
        │           └── seata/
        │               └── SeataConfig.java                   # Seata 配置
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

1. 确保 Nacos、RocketMQ 和 Seata 服务都已正确启动
2. 如需修改服务地址，可在 `bootstrap.yml` 文件中调整
3. 实际生产环境中，应根据需要配置更多参数

## 扩展建议

1. 添加更多微服务模块，构建完整的微服务架构
2. 集成 Spring Cloud Gateway 作为 API 网关
3. 添加分布式链路追踪（如 Sleuth + Zipkin）
4. 实现更复杂的业务逻辑，测试 Seata 的分布式事务能力
5. 配置 RocketMQ 的高级特性，如延迟消息、事务消息等