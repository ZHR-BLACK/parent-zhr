package com.zhr.boot.controller;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName PropertySourceController
 * @Date 2020-06-08 17:17
 * @description @PropertySource读取配置文件属性值
 **/
@Getter
@Slf4j
@RestController
@PropertySource(value = {"config/db-config.properties"})
public class PropertySourceController {

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    // 访问http://127.0.0.1:8080/propertySource
    @RequestMapping("/propertySource")
    public String propertySource(){
        log.info("username={}", username);
        log.info("password={}", password);
        return "success";
    }
}
