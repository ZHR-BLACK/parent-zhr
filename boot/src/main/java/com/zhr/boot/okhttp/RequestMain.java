package com.zhr.boot.okhttp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RequestMain {

    @RequestMapping(value = "/ok")
    public String receiveData() {
        Map map = new HashMap<>();
        map.put("a", "b");
        String post = OkHttpUtil.post("http://www.baidu.com", map);
        System.out.println("post:" + post);
        return "success";
    }
}
