package com.zhr.selfstudy.record;


import com.alibaba.fastjson.JSONObject;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName Main
 * @Date 2019-10-17 14:35
 * json 转Record类后的相关用法
 **/
public class RecordMain {

    public static void main(String[] args) {
        String jsonStr = "{" +
                "\"INFO\": {" +
                "\"TRX_CODE\": \"200004\"," +
                "\"RET_CODE\": \"0000\"," +
                "\"VERSION\": \"04\"," +
                "\"SIGNED_MSG\": \"42ff9c03c419d24ecaa979c1459b\"," +
                "\"ERR_MSG\": \"处理完成\"," +
                "\"DATA_TYPE\": \"2\"" +
                "}," +
                "\"QTRANSRSP\": {" +
                "\"QTDETAIL\": [{" +
                "\"BATCHID\": \"200604000007479-0001571023744921\"," +
                "\"TRXDIR\": \"0\"," +
                "\"SETTDAY\": \"20191014\"," +
                "\"FINTIME\": \"20191014113040\"," +
                "\"ACCOUNT_NAME\": \"张三000000\"," +
                "\"RET_CODE\": \"0000\"," +
                "\"AMOUNT\": \"200\"," +
                "\"SN\": \"0001\"," +
                "\"SUBMITTIME\": \"20191014112908\"," +
                "\"ACCOUNT_NO\": \"3228481200290317805\"," +
                "\"ERR_MSG\": \"处理成功\"" +
                "}, {" +
                "\"BATCHID\": \"200604000007479-0001571023744921\"," +
                "\"TRXDIR\": \"0\"," +
                "\"SETTDAY\": \"20191014\"," +
                "\"FINTIME\": \"20191014113040\"," +
                "\"ACCOUNT_NAME\": \"张三000000\"," +
                "\"RET_CODE\": \"0000\"," +
                "\"AMOUNT\": \"2\"," +
                "\"SN\": \"0002\"," +
                "\"SUBMITTIME\": \"20191014112908\"," +
                "\"ACCOUNT_NO\": \"3228481200290317805\"," +
                "\"ERR_MSG\": \"处理成功\"" +
                "}]" +
                "}" +
                "}";
        JSONObject object = JSONObject.parseObject(jsonStr);
        // json转为Record对象
        Record respRecord = JsonUtils.parse(object);
        Record qtransrsp = respRecord.get("QTRANSRSP");
        Object qtdetail = qtransrsp.get("QTDETAIL");

        if (qtdetail instanceof Record) {
            A a = setItem(A.class, "AAA", "aaa");
            System.out.println("a = " + a);
            System.out.println("a = " + a.getCode());
        } else if (qtdetail instanceof List) {
            B b = setItem(B.class, "BBB", "bbb");
            System.out.println("b = " + b);
            System.out.println("b = " + b.getCode());
        }
    }

    public static <T extends C> T setItem(Class<T> cls, String code, String msg) {
        try {
            T result = cls.newInstance();
            result.setCode(code);
            result.setMsg(msg);
            return result;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


}
