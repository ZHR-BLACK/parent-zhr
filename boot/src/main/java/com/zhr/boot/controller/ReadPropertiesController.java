package com.zhr.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReadPropertiesController
 * @Date 2020-06-08 16:42
 * @description 测试读取配置文件属性值
 *
 * @ConfigurationProperties 使用此标签要先生成属性的set和get方法
 **/
@RestController
@ConfigurationProperties(prefix ="db")
@PropertySource(value = {"config/db-config.properties"})
public class ReadPropertiesController {

    @Autowired
    private Environment env;

    private String username;
    private String password;

    // 访问http://127.0.0.1:8080/readPro
    @RequestMapping("/readPro")
    public void readPro() {
        String property = env.getProperty("server.connection-timeout");
        System.out.println("property ********************" + property);
    }

    @RequestMapping("/readPro2")
    public void readPro2(){
        System.out.println("username********************" + username);
        System.out.println("password********************" + password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
