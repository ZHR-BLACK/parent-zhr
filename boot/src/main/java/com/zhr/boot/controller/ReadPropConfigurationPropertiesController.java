package com.zhr.boot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@ConfigurationProperties(prefix ="info")
public class ReadPropConfigurationPropertiesController {

    private String address;
    private String company;

    // 访问http://127.0.0.1:8080/configurationProperties
    @RequestMapping("/configurationProperties")
    public void configurationProperties(){
        System.out.println("address********************" + address);
        System.out.println("company********************" + company);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }


}
