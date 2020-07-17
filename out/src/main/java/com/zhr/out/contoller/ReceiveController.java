package com.zhr.out.contoller;

import com.zhr.out.bean.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ReceiveController
 * @Date 2020-01-09 16:26
 * @description SpringBoot @PostMapper 接收HTTP 请求的流数据方式
 **/
@RestController
public class ReceiveController {

    private static Logger log = LoggerFactory.getLogger(ReceiveController.class);

    @RequestMapping(value = "/newlist", method = RequestMethod.POST)
    public void newList() {
        while (true) {
            List<String> list = new ArrayList<>(100000);
        }
    }
    // 模拟某个接口耗时很长
    @RequestMapping(value = "/sleep", method = RequestMethod.POST)
    public String sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sleep";
    }

    // SpringBoot @PostMapper 接收HTTP 请求的流数据方式
    // 访问url为http://111.231.107.12:8080/out/receive
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public String receiveData(@RequestBody byte[] data) throws UnsupportedEncodingException {
        String json = URLDecoder.decode(new String(data, "UTF-8"), "UTF-8");
        log.info(">>> 接收CP推送的消息：{}", json);

        return "success";
    }

    @RequestMapping("/data2")
    @ResponseBody
    public String receiveData2(@ModelAttribute Student student) {
        log.info(">>> 接收receiveData2推送的消息：{}", student);
        log.info("name:" + student.getName());

        return "success";
    }

}
