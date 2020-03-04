package com.zhr.selfstudy.request;

import cn.hutool.http.HttpUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName HttpGetRequest
 * @Date 2020-03-04 11:36
 * @description hutool get请求
 **/
public class HttpGetRequest {

    public static void main(String[] args) throws UnsupportedEncodingException {

        String s = HttpUtil.get("http://111.231.107.12:8080/out/data2?name=sas&age=234", Charset.forName("UTF-8"));
        System.out.println("s ********************" + s);
    }
}
