package com.zhr.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReadPropertiesController
 * @Date 2020-06-08 16:42
 * @description 测试读取配置文件属性值
 *
 * 成功读取
 **/
@RestController
public class ReadPropertiesController2 {

    @Value("${info.address}")
    private String address;

    @Value("${info.company}")
    private String company;

    // 访问http://127.0.0.1:8080/readinfo
    @RequestMapping("/readinfo")
    public void readinfo(){
        System.out.println("address********************" + address);
        System.out.println("company********************" + company);
    }
}
