package com.zhr.selfstudy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName MiyaController
 * @Date 2019/5/15 10:15
 * @description 从配置文件中读取属性值
 **/
@RestController
public class MiyaController {

    // 从配置文件中读取该属性值
    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping("miya")
    public String miya(){
        return name + ":" + age;
    }
}
