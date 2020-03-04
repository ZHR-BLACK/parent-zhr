package com.zhr.boot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReceiveController
 * @Date 2020-01-09 16:26
 * @description todo
 **/
@RestController
public class ReceiveController {

    private static Logger log = LoggerFactory.getLogger(ReceiveController.class);

    @RequestMapping("/receive")
    public String receiveData(@RequestBody byte[] data) throws UnsupportedEncodingException {
        String json = URLDecoder.decode(new String(data, "UTF-8"), "UTF-8");
        log.info(">>> 接收CP推送的消息：{}", json);

        return "success";
    }

}
