package com.zhr.selfstudy;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName StrTest
 * @Date 2020-03-25 17:55
 * @description todo
 **/
public class StrTest {

    public static void main(String[] args) {
        String s = "交易类报文发送前异常: [报文生成异常: [aaaaaa认证信息不匹配aaaaa]]";
//        if(s.contains("报文生成异常") && s.contains("[")){
//            String substring = s.substring(s.indexOf("报文生成异常:")).replaceAll("]", "");
//            System.out.println("substring ********************" + substring);
//            String substring1 = substring.substring(substring.indexOf("[") + 1);
//            System.out.println("substring1 ********************" + substring1);
//        }
        if(s.contains("]")){
            String substring = s.replaceAll("]", "").substring(s.lastIndexOf("[") + 1);
            System.out.println("substring ********************" + substring);
        }
    }

}
