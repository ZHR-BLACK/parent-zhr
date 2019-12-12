package com.zhr.selfstudy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName JsonValueDemo
 * @Date 2019-12-05 10:20
 * @description 正则截取json串中某key对应value值
 **/
public class JsonValueDemo {


    public static void main(String[] args) {
        String s = "{\"SystemHead\":[{\"XYSHBH\":\"2450697571\",\"SyMacFlag\":\"\",\"Flag\":\"\",\"MAC\":\"\",\"LicenseId\":\"\",\"PinSeed\":\"\",\"Language\":\"zh_CN\",\"Version\":\"\",\"ServiceName\":\"\",\"UserId\":\"002\",\"SyPinFlag\":\"\",\"Note\":\"\",\"Encodeing\":\"\"}],\"TransContent\":[{\"ReturnNote\":\"\",\"ReturnCode\":\"0000\",\"ReturnMsg\":\"本次交易成功！\",\"ClientPatchID\":\"20191203101019000001\",\"BatchRespList\":[{\"RespData\":[{\"YEWUZL\":\"1\",\"XYSHBH\":\"35503500201912030294\"}]}]}],\"schemaLocation\":\"http://www.cebbank.com/wangshangyh/ebankToBiz schema_v0.5.5.xsd\",\"TransHead\":[{\"JnlDate\":\"2019-12-03\",\"TransCode\":\"b2e005004\",\"BatchID\":\"B2EQUERY000088169603\",\"response3\":\"\",\"response2\":\"\",\"response1\":\"\",\"JnlTime\":\"2019-12-03 10:08:38.607\"}]}";

        // 适用于value都为数字型字符串
//        String reg = "(?<=\"XYSHBH\":\")\\d+";

        // 适用于value为字符串就可以
        String reg = "(?<=\"XYSHBH\":\").*?(?=(\"))";
        Pattern pattern = Pattern.compile(reg);
        Matcher mc = pattern.matcher(s);
        while (mc.find()) {
            System.out.println("匹配结果：");
            System.out.println(mc.group());
        }
    }
}
