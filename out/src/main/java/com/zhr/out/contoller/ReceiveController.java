package com.zhr.out.contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReceiveController
 * @Date 2020-01-09 16:26
 * @description  SpringBoot @PostMapper 接收HTTP 请求的流数据方式
 *
 **/
@RestController
public class ReceiveController {

    private static Logger log = LoggerFactory.getLogger(ReceiveController.class);

    // SpringBoot @PostMapper 接收HTTP 请求的流数据方式
    @RequestMapping("/receive")
    public String receiveData(@RequestBody byte[] data) throws UnsupportedEncodingException {
        String json = URLDecoder.decode(new String(data, "UTF-8"), "UTF-8");
        log.info(">>> 接收CP推送的消息：{}", json);

        return "success";
    }

}
