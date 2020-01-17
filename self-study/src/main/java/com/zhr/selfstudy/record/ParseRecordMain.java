package com.zhr.selfstudy.record;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName ParseRecordMain
 * @Date 2020-01-14 18:05
 * @description json转为Record后解析record
 **/
public class ParseRecordMain {

    public static void main(String[] args) {
//        String json = "{\"MessageSuit\":{\"Message\":{\"Plain\":{\"TrxId\":\"m7jt9tz2qg06\",\"date\":\"20200114 18:02:21\",\"amount\":0.23,\"charge\":0,\"clearDate\":20201124,\"transId\":\"NSOQRes\",\"currency\":156,\"id\":\"NSOQRes\",\"type\":1,\"serialNo\":\"iihadmuwzktp\",\"status\":\"0001\"},\"id\":\"m7jt9tz2qg06\"}}}";
//        JSONObject object = JSONObject.parseObject(json);
//        System.out.println("object ********************" + object);
//
//        Record respRecord = JsonUtils.parse(object);
//        Record messageSuit = respRecord.get("MessageSuit");
//        Record message = messageSuit.get("Message");
//        System.out.println("message ********************" + message);
//        Record plain = message.get("Plain");
//        String status = plain.getStr("status");
//        System.out.println("status ********************" + status);


        String json2 = "{\"MessageSuit\":{\"Message\":{\"Plain\":{\"amount\":0.23,\"clearDate\":20200115,\"transId\":\"PPRes\",\"cardLevel\":4,\"cardType\":\"D\",\"hostDateTime\":20200115113514,\"signNo\":\"2000723820QP20200113105007L0853117\",\"cardNo\":6226690200028929,\"serialNo\":\"yax4vcbdgcyb\",\"orderSeqNo\":\"\",\"checkMsgFlag\":0,\"merId\":365010000055,\"currency\":156,\"id\":\"PPRes\"},\"id\":\"yax4vcbdgcyb\"}}}";
        JSONObject object2 = JSONObject.parseObject(json2);
        Record respRecord2 = JsonUtils.parse(object2);
        Record messageSuit2 = respRecord2.get("MessageSuit");
        Record message2 = messageSuit2.get("Message");
        System.out.println("message ********************" + message2);
        Record plain2 = message2.get("Plain");
        System.out.println("plain2 ********************" + plain2);
        String checkMsgFlag = plain2.getStr("checkMsgFlag");



    }
}
