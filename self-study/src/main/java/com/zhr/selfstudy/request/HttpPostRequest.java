package com.zhr.selfstudy.request;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HttpRequest
 * @Date 2020-03-04 11:26
 * @description huttol   post请求
 **/
@Slf4j
public class HttpPostRequest {

    public static void main(String[] args) {
//        String post = HttpUtil.post("http://111.231.107.12:8080/receive", "a=1");
//        System.out.println("post ********************" + post);
////
//        Map<String, Object> map = new HashMap<>();
//        map.put("aa", "666");
//        String post1 = HttpUtil.post("http://111.231.107.12:8080/receive", map);
//        System.out.println("post1 ********************" + post1);

//        HttpUtil.post("http://111.231.107.12:8080/newlist", "");
//        HttpUtil.post("http://localhost:8080/redisTest", "");
//
//        for (int i = 0; i < 100; i++) {
//            new Thread(() -> {
//                HttpUtil.post("http://111.231.107.12:8080/out/sleep", "");
//            }).start();
//        }
        String post1 = null;
        try {
            // 设置超时时间
            post1 = HttpUtil.post("http://localhost:8080/yace", "", 5000);
        } catch (Exception e) {
            log.error("调用接口超时了", e);
        }
        System.out.println("post1 ********************" + post1);
    }
}

