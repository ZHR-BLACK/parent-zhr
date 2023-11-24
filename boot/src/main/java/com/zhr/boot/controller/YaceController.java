package com.zhr.boot.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YaceController {

    @RequestMapping(value = "/yace")
    public String receiveData() throws InterruptedException {
        System.out.println("receiveData");
        Thread.sleep(100000);
//        Object o = null;
//        for (int i = 0; i < 2000; i++) {
//            o = new Object();
//            System.out.println("o:" + o);
//        }

        return "success";
    }

}
