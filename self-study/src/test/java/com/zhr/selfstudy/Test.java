package com.zhr.selfstudy;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Test
 * @Date 2019-11-19 11:05
 * @description todo
 **/
public class Test {

    public static void main(String[] args) throws ParseException {
//        String s = "{\"SystemHead\":{\"UserID\":\"1\"},\"TransHead\":{\"JnlTime\":\"142209\",\"BatchID\":\"20200221142208000001\",\"Trans\n" +
//                "Code\":\"b2e004001\",\"JnlDate\":\"20200221\"},\"TransContent\":{\"ReqData\":{\"amount\":\"1.00\",\"toAccountNo\":\"79770188000015952\",\"isUrgent\":\"0\",\"transferType\":\"2122\",\"toAccountName\":\"光大永明人寿保险有限公司\",\"accountNo\":\"087552120100307000521\",\"perOrEnt\":\"0\",\"ClientPatchID\":\"20200221142208000001\",\"note\":\"保险理赔、保费退还\"\n" +
//                "}}}";
//
//        JSONObject object = JSONObject.parseObject(s);
//        System.out.println("object ********************" + object);
//
//        JSONObject jsonObject = object.getJSONObject("TransContent").getJSONObject("ReqData");
//        System.out.println("jsonObject ********************" + jsonObject);
//
//
//        Thread thread = Thread.currentThread();
//        System.out.println("thread ********************" + thread);
//        long id = thread.getId();
//        System.out.println("id ********************" + id);

//        JSONObject object = new JSONObject();
//        object.put("transDateTime", "2020-02-21T17:26:27");

        String s = "2020-02-21T17:26:27";
        String dateStr = s.replaceAll("T", " ");
        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateStr);
        String yyyyMMdd = new SimpleDateFormat("yyyyMMdd").format(parse);
        System.out.println("yyyyMMdd ********************" + yyyyMMdd);


    }
}
