package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName LastIndexOfTest
 * @Date 2019-12-12 15:51
 * @description 使用LastIndexOf根据某串来截取字符串
 **/
public class LastIndexOfTest {

    public static void main(String[] args) {
        String s = "ext/20191205/DDSS09436104";
        int i = s.lastIndexOf("/");
        String substring = s.substring(0, s.lastIndexOf("/") + 1);
        String substring2 = s.substring(s.lastIndexOf("/") + 1);
        System.out.println("substring ********************" + substring);
        System.out.println("substring2 ********************" + substring2);


        // 或者根据/分割字符串,截取需要的串
        String[] split = s.split("/");
        System.out.println("split ********************" + split[2]);


    }
}
