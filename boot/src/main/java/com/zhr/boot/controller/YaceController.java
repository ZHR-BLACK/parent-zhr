package com.zhr.boot.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YaceController {

    private static Logger log = LoggerFactory.getLogger(YaceController.class);

    @RequestMapping(value = "/yace")
    public String receiveData()  {

//        Thread.sleep(1000);
        Object o = null;
        for (int i = 0; i < 2000; i++) {
            o = new Object();
            System.out.println("o:" + o);
        }

        return "success";
    }

}
