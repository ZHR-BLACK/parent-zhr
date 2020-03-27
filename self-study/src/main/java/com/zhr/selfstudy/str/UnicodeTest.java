package com.zhr.selfstudy.str;

/**
 * @author ZHR
 * @version 1.0
 * @ClassName UnicodeTest
 * @Date 2020-01-06 14:08
 * @description string转为unicode  用于一些不支持中文的地方
 **/
public class UnicodeTest {

    public static void main(String[] args) {

        String a = "041@8100000000011748@中国光大银行股份有限公司@00000005";
        String s = str2unicode(a);
        System.out.println("s ********************" + s);

    }

    public static String str2unicode(final String gbString) {
        char[] utfBytes = gbString.toCharArray();
        String unicodeBytes = "";
        for (int byteIndex = 0; byteIndex < utfBytes.length; byteIndex++) {
            String hexB = Integer.toHexString(utfBytes[byteIndex]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;
            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;
        }
        return unicodeBytes;
    }
}
