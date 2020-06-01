package com.zhr.selfstudy.str;

import cn.hutool.core.text.StrBuilder;

import java.text.DecimalFormat;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName SupplementZeroTest
 * @Date 2020-04-17 17:49
 * @description 字符串右补空格,数字左补0
 **/
public class SupplementZeroTest {

    //1，正数左补零 
    public static void main(String[] args) {
        int youNumber = 1;
        // 0 代表前面补充0      
        // 4 代表长度为4      
        // d 代表参数为正数型      
        String str = String.format("%04d", youNumber);
        System.out.println(str); // 0001

        String format = String.format("%012d", 159);
        System.out.println("format ********************" + format);


        //2，double数变换字符串并去掉”.”比如double 12.12 =》1212
        Double price = 12.12 * 100;
        DecimalFormat df = new DecimalFormat("######0");
        String price1 = df.format(price);
        System.out.println("price1 ********************" + price1);

        //3,字符串右补空格，String字节60位不够右补空格
        String s = "asd";
        String repo_Mess1 = String.format("%1$-10s", s);
        System.out.println("repo_Mess1 ********************" + repo_Mess1.length());

        //4,字符串左补零 
        String ss = "sasd";
        // 不够10位左补0
        int list = 10 - ss.length();
        StrBuilder sb = new StrBuilder();
        for (int i = 0; i < list; i++) {
            sb.append("0");
        }
        sb.append(ss);
        System.out.println("sb********************" + sb.toString());
    }
}
