package com.zhr.selfstudy.request;

import cn.hutool.http.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HttpRequest
 * @Date 2020-03-04 11:26
 * @description huttol   post请求
 *
 **/
public class HttpPostRequest {

    public static void main(String[] args) {
        String post = HttpUtil.post("http://111.231.107.12:8080/out/receive", "a=1");
        System.out.println("post ********************" + post);

        Map<String, Object> map = new HashMap<>();
        map.put("aa", "666");
        String post1 = HttpUtil.post("http://111.231.107.12:8080/out/receive", map);
        System.out.println("post1 ********************" + post1);

    }
}
