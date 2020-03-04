package com.zhr.out;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;


/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReceiveController
 * @Date 2020-03-04 16:26
 * @description SpringBoot 本地启动时启动类需要做的配置
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
public class OutApplication{

    public static void main(String[] args) {
        SpringApplication.run(OutApplication.class, args);
    }

}
