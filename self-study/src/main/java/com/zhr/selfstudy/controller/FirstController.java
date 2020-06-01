package com.zhr.selfstudy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName FirstController
 * @Date 2019/5/14 18:28
 * @description controller相关demo
 * @RestController和@RequestMapping的使用
 **/
@RestController
public class FirstController {

    @RequestMapping("hello")
    public String index() {
        return "first controller";
    }

}
